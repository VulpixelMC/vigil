package gay.sylv.vigil.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.mojang.datafixers.util.Either;
import gay.sylv.vigil.stats.VigilStats;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class Mixin_Player extends LivingEntity {
	protected Mixin_Player(EntityType<? extends LivingEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Shadow
	public abstract void resetStat(Stat<?> stat);

	@Shadow
	public abstract void awardStat(ResourceLocation statKey);

	@WrapWithCondition(
			method = "tick",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/player/Player;sleepCounter:I",
					opcode = Opcodes.PUTFIELD
			)
	)
	private boolean cancelSleepCounter(Player instance, int newValue) {
		return false;
	}

	@Inject(
			method = "tick",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/player/Player;sleepCounter:I",
					opcode = Opcodes.PUTFIELD,
					ordinal = 0
			)
	)
	private void onCountSleep(CallbackInfo ci) {
		if (!this.level().isClientSide()) {
			this.awardStat(VigilStats.LAST_REST_DURATION);
		}
	}

	@Inject(
			method = "startSleepInBed",
			at = @At("HEAD")
	)
	private void onStartSleeping(BlockPos bedPos, CallbackInfoReturnable<Either<Player.BedSleepingProblem, Unit>> cir) {
		if (!this.level().isClientSide()) {
			this.resetStat(VigilStats.getStat(VigilStats.LAST_REST_DURATION));
		}
	}
}
