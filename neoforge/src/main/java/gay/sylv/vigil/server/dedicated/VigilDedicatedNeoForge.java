package gay.sylv.vigil.server.dedicated;

import gay.sylv.vigil.Vigil;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(
		value = Vigil.MOD_ID,
		dist = Dist.DEDICATED_SERVER
)
public class VigilDedicatedNeoForge {
	public VigilDedicatedNeoForge() {
		VigilDedicated.init();
	}
}
