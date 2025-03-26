package gay.sylv.vigil.client;

import net.fabricmc.api.ClientModInitializer;

public class VigilClientFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		VigilClient.init();
	}
}
