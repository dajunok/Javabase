package liu.java.util.classes.IntSummaryStatistics;

/**
 * '::'关键字符号的运用
 * @author LIU
 *
 */


public class TestIntSummaryStatistics {
	
	public static void main(String[] args) {
		// static methods
		IConvert<String, String> convert = Something::startsWith;
		String converted = convert.convert("123");
		System.out.println(converted);
	
		 
		// object methods
		Something something = new Something();
		IConvert<String, String> converter = something::endWith;
		converted = converter.convert("Java");
		System.out.println(converted);
		
		 
		// constructor methods
		IConvert<String, Something> convert2 = Something::new;
		Something someth = convert2.convert("constructors");

		
		/**
		 * 总结：我们可以把类Something中的方法static String startsWith(String s){...}、
		 * String endWith(String s){...}、Something(String something){...}看作是接口IConvert的实现，
		 * 因为它们都符合接口定义的那个“模版”，有传参类型F以及返回值类型T。比如构造方法Something(String something)，
		 * 它传参为String类型，返回值类型为Something。注解@FunctionalInterface保证了接口有且仅有一个抽象方法，
		 * 所以JDK能准确地匹配到相应方法。
		 */

	}


}

class Something {
	 
    // constructor methods
    Something() {}
 
    Something(String something) {
    	System.out.println(something);
    }
 
    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
    
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }
    
    void endWith() {}
}

@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}





















