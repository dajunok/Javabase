package liu.java.util.function.BiFunction;

import static org.mockito.Matchers.byteThat;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {
	public static void main(String[] args) {
		
		//匿名类方式调用apply
		int j=DefBiFunction.sum(15, 30, new BiFunction<Integer, Integer, Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				System.out.println("计算a与b的和j：");
				return a+b;
			}
		});
		System.out.println(j);		
		//lambda方式调用apply
		int i=DefBiFunction.sum(10, 20, (a,b)->{System.out.println("计算a与b的和i：");return a+b;});
		System.out.println(i);
		
		
		
		//匿名类方式调用andThen：先调用BiFunction的apply(a, b)，然后调用Function的apply(apply(a, b))方法。 也就是把第一个调用的结果作为参数传给第二个调用。
		int k=DefBiFunction.compute(2, 3, new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}, new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}
		});
		System.out.println("k= "+k);		
		//lambda方式调用andThen
		int f=DefBiFunction.compute(2, 3,(a,b)->{return a+b;},(c)->{return c*c;});
		System.out.println("f= "+f);
		
	}

}
