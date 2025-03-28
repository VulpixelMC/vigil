package gay.sylv.vigil.stats;

import gay.sylv.vigil.Vigil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public final class VigilStats {
	public static ResourceLocation LAST_REST_DURATION;

	private VigilStats() {}

	public static void init() {
		LAST_REST_DURATION = makeCustomStat("last_rest_duration", StatFormatter.TIME);
	}

	public static Stat<ResourceLocation> getStat(ResourceLocation id) {
		return Stats.CUSTOM.get(id);
	}

	private static ResourceLocation makeCustomStat(String key, StatFormatter formatter) {
		ResourceLocation resourceLocation = Vigil.modId(key);
		Registry.register(BuiltInRegistries.CUSTOM_STAT, key, resourceLocation);
		Stats.CUSTOM.get(resourceLocation, formatter);
		return resourceLocation;
	}
}
