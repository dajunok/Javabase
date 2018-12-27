package liu.java.util.function.Lambda;

import java.util.ArrayList;
import java.util.List;
import liu.lang.Class.AboutInstance.Color;

public class Test {
	//将接口作为函数形参
	public static List<Apple> filterApplesByAppleFilter(List<Apple> apples, AppleFilter filter) {
	    List<Apple> filterApples = new ArrayList<Apple>();
	    for (final Apple apple : apples) {
	        if (filter.accept(apple)) {
	            filterApples.add(apple);
	        }
	    }
	    return filterApples;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//具体调用：
		    List<Apple> apples = new ArrayList<Apple>();

	    // 筛选苹果
	    List<Apple> filterApples = filterApplesByAppleFilter(apples, new AppleFilter() { 	//接口实现作为函数实参
	  			public boolean accept(Apple apple) {
	            // 筛选重量大于100g的红苹果
	            return Color.RED.equals(apple.getColor()) && apple.getWeight() > 100;
	        }
	    });
	    
	 // 筛选苹果(Lambda样式)
	    List<Apple> filterApplesLambda = filterApplesByAppleFilter(apples,
	            (Apple apple) -> Color.RED.equals(apple.getColor()) && apple.getWeight() >= 100);
	    
	}

}

