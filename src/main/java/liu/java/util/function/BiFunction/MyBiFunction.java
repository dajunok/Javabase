package liu.java.util.function.BiFunction;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface MyBiFunction<T,U,R> {
	R apply(T t, U u);
	
	default <V> MyBiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }

}
