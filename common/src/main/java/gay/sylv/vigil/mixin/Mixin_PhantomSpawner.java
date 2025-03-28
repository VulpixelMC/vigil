package gay.sylv.vigil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gay.sylv.vigil.stats.VigilStats;
import gay.sylv.vigil.util.TickUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatType;
import net.minecraft.world.level.levelgen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PhantomSpawner.class)
public class Mixin_PhantomSpawner {
	@WrapOperation(
			method = "tick",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/stats/StatType;get(Ljava/lang/Object;)Lnet/minecraft/stats/Stat;")
	)
	private Stat<ResourceLocation> useVigilStat(StatType<ResourceLocation> instance, Object value, Operation<Stat<ResourceLocation>> original) {
		return VigilStats.getStat(VigilStats.LAST_REST_DURATION);
	}

	@ModifyConstant(
			method = "tick",
			constant = @Constant(intValue = 72000)
	)
	private int setPhantomSpawnTime(int constant) {
		return TickUtil.seconds(15) / 2;
	}
}
