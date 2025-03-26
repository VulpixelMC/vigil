package gay.sylv.vigil.mixin;

import net.minecraft.world.entity.player.Player;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public class Mixin_Player {
	@Redirect(
			method = "tick",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/player/Player;sleepCounter:I",
					opcode = Opcodes.PUTFIELD
			)
	)
	private void cancelSleepCounter(Player instance, int newValue) {
	}
}
