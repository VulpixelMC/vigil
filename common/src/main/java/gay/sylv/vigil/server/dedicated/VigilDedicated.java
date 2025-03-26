package gay.sylv.vigil.server.dedicated;

import gay.sylv.vigil.Vigil;
import org.slf4j.Logger;

public class VigilDedicated {
	public static final Logger LOG = Vigil.getLogger("Dedicated Server");

	public static void init() {
		LOG.info("Initializing Vigil Dedicated Server");
	}
}
