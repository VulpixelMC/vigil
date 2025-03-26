package gay.sylv.vigil;

import net.fabricmc.api.ModInitializer;

public class VigilFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Vigil.LOG.info("Hello Fabric world!");
        Vigil.init();
    }
}
