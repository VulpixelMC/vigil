package gay.sylv.vigil.platform;

import gay.sylv.vigil.platform.side.Side;
import net.fabricmc.loader.api.FabricLoader;

public class VigilPlatformHelperFabric implements VigilPlatformHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

	@Override
	public Side getSide() {
		return switch (FabricLoader.getInstance().getEnvironmentType()) {
			case CLIENT -> Side.CLIENT;
			case SERVER -> Side.DEDICATED;
		};
	}
}
