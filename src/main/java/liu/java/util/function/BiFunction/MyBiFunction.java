package liu.java.util.function.BiFunction;

import java.util.Objects;
import java.util.function.Function;

/**
 * 	模拟定义BiFunction函数接口
 * @author LIU
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface MyBiFunction<T,U,R> {	
	R apply(T t, U u);
	
	/*定义一个andThen方法，该方法返回MyBiFunction<T, U, V> 
	 * 	注意！<V>是andThen方法返回值根据需要添加了一个泛型类型【V】。
	 */
	
	
	//通过Lambda表达式实现andThen
	default <V> MyBiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);         
        MyBiFunction<T, U, V> myBiFunction=(T t, U u) -> after.apply(this.apply(t, u)); //实例化一个MyBiFunction，然后返回这个实例。
        return myBiFunction; //返回函数接口实例
    }
	
	//通过匿名内部类实现andThen   ——注意：调用时会陷入死循环，此方式只是用于对比Lambda表达式
	default <V> MyBiFunction<T, U, V> andThen2(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);         
        MyBiFunction<T, U, V> myBiFunction=new MyBiFunction<T, U, V>(){
			@Override
			public  V apply(T t, U u) {
				return after.apply((R) apply(t, u));
			}
			
		};
        return myBiFunction; //返回函数接口实例
	}
	
}
