package gay.sylv.vigil.client;

import gay.sylv.vigil.Vigil;
import org.slf4j.Logger;

public class VigilClient {
	public static final Logger LOG = Vigil.getLogger("Client");

	public static void init() {
		LOG.info("Initializing Vigil Client");
	}
}
