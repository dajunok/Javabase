package liu.lang.Class;

public class Test_EnclosingClass {
	/*	getDeclaringClass():Class<?>	获取成员内部类在定义时所在的类。
		getEnclosingClass():Class<?>	获取内部类在定义时所在的类。
		getEnclosingConstructor():Constructor	获取局部或匿名内部类在定义时所在的构造器。
		getEnclosingMethod():Method	获取局部或匿名内部类在定义时所在的方法。
		isMemberClass():boolean		查看是否成员内部类。
		isLocalClass():boolean			查看是否局部内部类。
		isAnonymousClass():boolean		查看是否匿名内部类。
	 * 网络上查阅中，其中对内部类的划分有：常规内部类，静态内部类，局部内部类，匿名内部类。
	 * 下面的述语中，成员内部类是指常规内部类与静态内部类。
	 * 
	 */
    public static void printInnerClass(String name, Class<?> clazz){
        System.out.println(name + " -> DeclaringClass=\t" + clazz.getDeclaringClass());
        System.out.println(name + " -> EnclosingClass=\t" + clazz.getEnclosingClass());
        System.out.println(name + " -> EnclosingConstructor=" + clazz.getEnclosingConstructor());
        System.out.println(name + " -> EnclosingMethod=\t" + clazz.getEnclosingMethod());
        System.out.println(name + " -> 是否成员内部类=\t" + clazz.isMemberClass());
        System.out.println(name + " -> 是否局部内部类=\t" + clazz.isLocalClass());
        System.out.println(name + " -> 是否匿名内部类=\t" + clazz.isAnonymousClass());
    }

	public static void main(String[] args) {
		(new Test_EnclosingClass()).test();

	}
	
	public void test(){
        printInnerClass("常规内部类", Test_EnclosingClass.InnerClass.InnerClass2.class);


        System.out.println("[1]---------------------------------------------------------------------------------------");
        printInnerClass("静态内部类", StaticInnerClass.StaticInnerClass2.class);


        System.out.println("[2]---------------------------------------------------------------------------------------");
        class LocalInnerClass { }
        printInnerClass("局部内部类", LocalInnerClass.class);


        System.out.println("[3]---------------------------------------------------------------------------------------");
        Object obj = new Object(){ };
        printInnerClass("匿名内部类", obj.getClass());

    }
    

    
    public class InnerClass {
        public class InnerClass2 {
            
        }
    }
    
    public static class StaticInnerClass {
        public static class StaticInnerClass2 {
            
        }
    }

}
