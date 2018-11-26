package liu.lang.Class;

class ClassTest { 
	public ClassTest() {
		System.out.println("构造方法");
	} 
	static {
		System.out.println("静态参数的初始化");
	} 
	{
		System.out.println("非静态参数的初始化");
	}
}

class Father {
 
	public Father() {
		System.out.println("Father类的构造方法：");
		System.out.println("Father.class：" + Father.class);
		System.out.println("getClass() " + getClass());
	}
 
}

class Son extends Father {
 
}
 
public class AboutgetClassAndforName {
	public static void main(String[] args) throws ClassNotFoundException {
		// .class
		System.out.println(".class>>>" + ClassTest.class);
 
		// class.forName
		Class<?> clazz = Class.forName("liu.lang.Class.ClassTest");
		System.out.println("class.forName>>>" + clazz);
 
		// getClass
		System.out.println("getClass>>>" + new ClassTest().getClass());
		
		
		new Son();
		/*运行结果：
		Father类的构造方法：
		Father.class：class liu.lang.Class.Father
		getClass()：class liu.lang.Class.Son
		从结果看来，getClass()获取的是实际运行的类的字节码，它不一定是当前类的Class，
		有可能是当前类的子类的Class，具体是哪个类的Class，需要根据实际运行的类来确定，
		new的是哪个类，getClass()获取的就是哪个类的Class；
		而类.class获取得到的Class永远只能是该类的Class。
		 */
	}
}
	


