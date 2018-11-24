package liu.lang.Class;

interface inter{}

class Clzzz{}

@interface TestAnno{}

enum Enum { }


public class AboutType {
	public static void print(String name, Class<?> clazz){
        System.out.println(name + " -> 是否基本数据类型=" + clazz.isPrimitive());
        System.out.println(name + " -> 是否数组=\t" + clazz.isArray());
        System.out.println(name + " -> 是否接口=\t" + clazz.isInterface());
        System.out.println(name + " -> 是否注解=\t" + clazz.isAnnotation());
        System.out.println(name + " -> 是否枚举=\t" + clazz.isEnum());
    }
	
	public static class TestClass { }
    public static interface TestInterface { }
    public static @interface TestAnnotation { }
    public static enum TestEnum { }
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("(1)=================================================");
		print("基本数据类型", int.class);
		
		System.out.println("(2)=================================================");
		print("数组", int[].class);
		
		System.out.println("(3)=================================================");
		print("接口", TestInterface.class);
		print("接口", inter.class);
		print("接口", Class.forName("liu.lang.Class.inter"));
		
		System.out.println("(4)=================================================");
		print("注解", Class.forName("liu.lang.Class.TestAnno"));
		print("注解", TestAnnotation.class);
		
		System.out.println("(5)=================================================");
		print("枚举", TestEnum.class);
		
		System.out.println("(6)=================================================");
		print("数组", int[].class);
		
		System.out.println("(7)=================================================");
		print("类", Clzzz.class);
		print("类", Class.forName("liu.lang.Class.Clzzz"));
		print("类", new Clzzz().getClass());
	}

}
