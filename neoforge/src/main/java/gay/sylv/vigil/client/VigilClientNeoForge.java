package gay.sylv.vigil.client;

import gay.sylv.vigil.Vigil;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(
		value = Vigil.MOD_ID,
		dist = Dist.CLIENT
)
public class VigilClientNeoForge {
	public VigilClientNeoForge() {
		VigilClient.init();
	}
}
