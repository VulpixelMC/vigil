package gay.sylv.vigil;

import gay.sylv.vigil.platform.VigilPlatformHelperFabric;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class VigilFabricPre implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        Vigil.setHelper(new VigilPlatformHelperFabric());
    }
}
