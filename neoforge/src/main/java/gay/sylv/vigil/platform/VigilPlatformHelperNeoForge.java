package gay.sylv.vigil.platform;

import gay.sylv.vigil.platform.side.Side;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class VigilPlatformHelperNeoForge implements VigilPlatformHelper {
    @Override
    public Platform getPlatform() {
        return Platform.NEOFORGE;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

	@Override
	public Side getSide() {
		return switch (FMLLoader.getDist()) {
			case CLIENT -> Side.CLIENT;
			case DEDICATED_SERVER -> Side.DEDICATED;
		};
	}
}
