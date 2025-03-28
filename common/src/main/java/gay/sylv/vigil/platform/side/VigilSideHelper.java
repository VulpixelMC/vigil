package gay.sylv.vigil.platform.side;

import gay.sylv.vigil.Vigil;

import java.util.ServiceLoader;

/**
 * Shared utilities for side-specific behavior.
 */
public interface VigilSideHelper<S extends VigilSideHelper<S>> extends ServiceLoader.Provider<VigilSideHelper<S>> {
	static VigilSideHelper<?> load() {
		var loaders = ServiceLoader.load(VigilSideHelper.class);
		// Maintain sanity
		if (loaders.stream().findAny().isEmpty()) {
			throw new IllegalStateException("No " + VigilSideHelper.class.getName() + " implementation found");
		}

		return loaders
				.stream()
				.filter(provider -> {
					final String pkg = provider.type().getPackage().getName();
					return switch (Vigil.getHelper().getSide()) {
						case CLIENT -> pkg.startsWith(Vigil.CLIENT_PACKAGE);
						case DEDICATED -> pkg.startsWith(Vigil.DEDICATED_PACKAGE);
					};
				})
				.findFirst()
				.orElseThrow()
				.get();
	}
}
