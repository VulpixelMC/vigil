package gay.sylv.vigil;

import gay.sylv.vigil.platform.VigilPlatformHelper;
import gay.sylv.vigil.platform.side.VigilSideHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vigil {
    public static final String MOD_ID = "vigil";
    public static final String MOD_NAME = "Vigil";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	public static final String CLIENT_PACKAGE = "gay.sylv.vigil.client";
	public static final String DEDICATED_PACKAGE = "gay.sylv.vigil.server.dedicated";

    private static VigilPlatformHelper helper;
	private static VigilSideHelper<?> sideHelper;

    public static void init() {
		LOG.info("Initializing {}", MOD_NAME);
		sideHelper = VigilSideHelper.load();
    }

	public static Logger getLogger(String ...subsystems) {
		return LoggerFactory.getLogger(MOD_NAME + "/" + String.join("/", subsystems));
	}

    public static VigilPlatformHelper getHelper() {
        return helper;
    }

    public static void setHelper(VigilPlatformHelper helper) {
        Vigil.helper = helper;
    }

	public static VigilSideHelper<?> getSideHelper() {
		return sideHelper;
	}
}
