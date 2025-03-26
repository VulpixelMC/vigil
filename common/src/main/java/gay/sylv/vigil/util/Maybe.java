package gay.sylv.vigil.util;

import java.util.Objects;
import java.util.function.Supplier;

public final class Maybe<T> {
	private T value;

	public Maybe(T value) {
		this.value = value;
	}

	public Maybe() {
		this.value = null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Maybe<?> maybe) {
			return maybe.value != null &&
					value != null &&
					value.getClass().isAssignableFrom(maybe.value.getClass()) &&
					Objects.equals(value, obj);
		} else {
			return value != null &&
					value.getClass().isAssignableFrom(obj.getClass()) &&
					Objects.equals(value, obj);
		}
	}

	@Override
	public String toString() {
		return "Maybe[" + value + "]";
	}

	public T computeIfAbsent(Supplier<T> supplier) {
		if (value != null) {
			return value;
		} else {
			value = supplier.get();
			return supplier.get();
		}
	}
}
