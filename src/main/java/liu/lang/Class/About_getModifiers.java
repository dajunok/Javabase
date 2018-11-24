package liu.lang.Class;

import java.lang.reflect.Modifier;

public class About_getModifiers {
	static interface Inter{}
	static class Clazz{}
	static @interface TestAnnotation{}
	
	public static void main(String[] args) {
		//获取类的修饰符
		Class<Inter> clazz=Inter.class;
		System.out.println(clazz.getModifiers());
		System.out.println(Modifier.toString(clazz.getModifiers()));
		System.out.println(About_getModifiers.class.getModifiers());
	}

}
