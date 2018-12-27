package liu.java.util.function.BiFunction;

import java.util.function.Function;



/**
 * 	测试函数式接口组合方法：compose()、andThen()等等
 * @author LIU
 *
 */
public class TestFCompose {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//------------------------------函数式接口组合方法运用案例分析-----------------------------
		System.out.println("函数式接口组合方法运用案例 -------------------------------------------------------------------");
		Function<Integer, Integer> f = x -> x + 2;  //实例化一个函数式接口
		Function<Integer, Integer> g = x -> x * 4;  //实例化一个函数式接口
		Function<Integer, Integer> fAndThenG = f.andThen(g);  //实例化一个函数式接口		 
		Function<Integer, Integer> gAndThenF = g.andThen(f);  //实例化一个函数式接口
		Function<Integer, Integer> gAndThenF2=(x)->f.apply(g.apply(x)); //实例化一个函数式接口
		for(int i = 1; i<3; i++){
			System.out.println(gAndThenF2.apply(i));
		}
		
		
		//return (T t, U u) -> after.apply(apply(t, u));

	}

}
