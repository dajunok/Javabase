package liu.lang.Class;


public class About_getPackage {
	
	static interface Inter{}
	static class Clazz{}
	static @interface TestAnnotation{}

	public static void main(String[] args) throws ClassNotFoundException {
	//getPackage()方法用于获取类在定义时所在的包。
	System.out.println("packageName: "+Class.forName("liu.lang.Class.About_getPackage$Inter").getPackage().getName());
	System.out.println("packageName: "+Clazz.class.getPackage().getName());	

	}

}
