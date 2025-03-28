package gay.sylv.vigil.util;

public final class TickUtil {
	private TickUtil() {}

	public static int seconds(int seconds) {
		return 20 * seconds;
	}

	public static int minutes(int minutes) {
		return seconds(60 * minutes);
	}
}
