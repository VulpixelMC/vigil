package gay.sylv.vigil.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.world.entity.player.Player;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public class Mixin_Player {
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
}
