package gay.sylv.vigil;


import gay.sylv.vigil.platform.VigilPlatformHelperNeoForge;
import net.neoforged.fml.common.Mod;

@Mod(Vigil.MOD_ID)
public class VigilNeoForge {
    public VigilNeoForge() {
        Vigil.setHelper(new VigilPlatformHelperNeoForge());
	    Vigil.init();
    }
}
