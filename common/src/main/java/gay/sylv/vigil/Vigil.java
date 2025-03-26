package gay.sylv.vigil;

import gay.sylv.vigil.platform.VigilPlatformHelper;
import gay.sylv.vigil.platform.side.VigilSideHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vigil {
    public static final String MOD_ID = "vigil";
    public static final String MOD_NAME = "Vigil";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    private static VigilPlatformHelper helper;
	private static VigilSideHelper<?> sideHelper;

    public static void init() {
		LOG.info("Initializing Vigil");
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
		if (sideHelper == null) {
			sideHelper = VigilSideHelper.load();
		}

		return sideHelper;
	}
}
