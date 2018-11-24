package liu.lang.Class;

import java.lang.reflect.Constructor;

/*构造器（构造函数）
 * 	getConstructor(Class<?>...):Constructor<T>  返回问权限是public的构造器(通过参数过滤指定某一个具体构造器)
 *	getConstructors():Constructor<?>[]   返回问权限是public的所有构造器。
 *	getDeclaredConstructor(Class<?>...):Constructor<T>  通过参数过滤指定某一个具体构造器（可以是任何访问权限public、protected或者private）
 *	getDeclaredConstructors():Constructor<?>[]  返回所有构造器，包括public的和非public的，当然也包括private的。
 */

public class AboutConstructor {
	
	public AboutConstructor(String str) {}
	
	public static class TestClass {
	 	private short i;
	 	private int j;
	 	private long k;
	 	
	 	public TestClass(String str) {
	 	}
	
	    private TestClass(short i) {this.i=i;}
	    
	    protected TestClass(int j) {this.j=j;}
	    
	    public TestClass(long k) {this.k=k;}
	}
	 
	 
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		//返回问权限是public的构造器(通过参数过滤指定某一个具体构造器)
		System.out.println("(1)===========================================");
		System.out.println(TestClass.class.getConstructor(long.class).toString());
		System.out.println(Class.forName("liu.lang.Class.AboutConstructor$TestClass").getConstructor(long.class));
		System.out.println(AboutConstructor.class.getConstructor(String.class));
		
		//返回问权限是public的所有构造器。
		System.out.println("(2)===========================================");
		Constructor<?>[] contarry=TestClass.class.getConstructors();
		for(Constructor<?> constructor:contarry) {
			System.out.println(constructor.toString());
		}
		
		//通过参数过滤指定某一个具体构造器（可以是任何访问权限public、protected或者private）
		System.out.println("(3)===========================================");
		System.out.println(TestClass.class.getDeclaredConstructor(short.class).toString());
		System.out.println(Class.forName("liu.lang.Class.AboutConstructor$TestClass").getDeclaredConstructor(int.class));
		System.out.println(AboutConstructor.class.getDeclaredConstructor(String.class));
		
		//返回所有构造器，包括public的和非public的，当然也包括private的。
		System.out.println("(4)===========================================");
		Constructor<?>[] contDarry=TestClass.class.getDeclaredConstructors();
		for(Constructor<?> constructor:contDarry) {
			System.out.println(constructor.toString());
		}		

		
	}
	


}
