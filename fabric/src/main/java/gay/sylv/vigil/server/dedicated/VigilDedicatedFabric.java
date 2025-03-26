package gay.sylv.vigil.server.dedicated;

import net.fabricmc.api.DedicatedServerModInitializer;

public class VigilDedicatedFabric implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		VigilDedicated.init();
	}
}
