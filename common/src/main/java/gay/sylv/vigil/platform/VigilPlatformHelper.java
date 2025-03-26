package gay.sylv.vigil.platform;

import gay.sylv.vigil.platform.side.Side;

public interface VigilPlatformHelper {
    /**
     * Gets the current platform
     *
     * @return An enum value representing the current platform.
     */
    Platform getPlatform();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

	/**
	 * Gets the current distribution side.
	 * @return The distribution side that this mod is running in.
	 */
	Side getSide();
}
