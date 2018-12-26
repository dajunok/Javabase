package liu.java.util.function.BiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 测试BiFunction函数式接口在类方法定义中的运用
 * @author LIU
 *
 */
public class DefBiFunction {
	
	//函数式接口BiFunction对两个整数求和并返回
	public static int sum(int a,int b,BiFunction<Integer,Integer,Integer> total){
		int i=total.apply(a, b);
	    return i;
	}
	
	
	/**使用函数式接口BiFunction的andThen方法。先调用BiFunction的apply(a, b)，然后调用Function的apply(apply(a, b))方法。
	 * 也就是把第一个调用的结果作为参数传给第二个调用。
	 *默认实现代码如下：
		default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
	        Objects.requireNonNull(after);
	        return (T t, U u) -> after.apply(apply(t, u));
	    }
	*/
	public static int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,Function<Integer, Integer> function) {
	    return biFunction.andThen(function).apply(a, b);
	}
	
}

