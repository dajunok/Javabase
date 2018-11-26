package liu.lang.Class;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.reflect.annotation.TypeAnnotationParser;
import sun.security.util.SecurityConstants;

class A {
	public A() {
		// TODO Auto-generated constructor stub
	}
    public void show() {
        System.out.println("Class A show() function");
    }
}

class B extends A {
    public void show() {
        System.out.println("Class B show() function");
    }
} 

public class TestClass {
	

	public static void main(String[] args) throws ClassNotFoundException {
		/*【1】
		 * 源代码
		 * @SuppressWarnings("unchecked")
		 * public <U> Class<? extends U> asSubclass(Class<U> clazz) {
		 * 	if (clazz.isAssignableFrom(this))
         *  	return (Class<? extends U>) this;
         *	else
         *   	throw new ClassCastException(this.toString());
    	 * }
    	 * 函数功能如下：
		 * 其作用是将一个Class对象转换成为指定了泛型的Class对象，经常用于你不知道Class对象是什么类型的时候，例如Class.forName(str)他只能返回一个Class<?>，
		 * 这时你需要将其转换为一个Class<? extends XXX>的对象（可能是添加到制定了泛型的集合里面）。asSubClass这个方法会用于你不知道你持有的Class对象的泛型是什么，
		 * 而且你需要进行泛型参数向下转型
		 * 
		 */
		List<String> strList = new ArrayList<String>();  
		Class<? extends List> strList_cast = strList.getClass().asSubclass(List.class); 
		
		
		
		/*【2】
		 * 源代码
		 * 		@SuppressWarnings("unchecked")
		 * 	    public T cast(Object obj) {
		 * 	        if (obj != null && !isInstance(obj))
		 * 	            throw new ClassCastException(cannotCastMsg(obj));
		 * 	        return (T) obj;
		 * 	    }
		 * 	
		 * 函数功能如下：
		 * 将一个对象装换为类或者接口。此方法只能转换当前类型或其子类下的对象，只是简单进行强转。
		 * 	
	    */
		A a=new A();
		B b = new B();
        a = A.class.cast(b);
        a.show();
        
        /*【3】
         * 源代码
         * @CallerSensitive
         * public static Class<?> forName(String className)throws ClassNotFoundException {
         * 		Class<?> caller = Reflection.getCallerClass();
         * 		return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
         * }
         * 函数功能如下：返回与给定的字符串名称相关联类或接口的Class对象。Class.forName是一个静 态方法，同样可以用来加载类。
         * 该方法有两种形式：Class.forName(String name, boolean initialize, ClassLoader loader)
         * 和 Class.forName(String className)。第一种形式的参数 name表示的是类的全名；initialize表示是否初始化类；
         * loader表示加载时使用的类加载器。第 二种形式则相当于设置了参数 initialize的值为 true，loader的值为当前类的类加载器。
         */
        Class cl=Class.forName("liu.lang.Class.A");
        System.out.println("cl Name = " + cl);
        
        /*【4】
         * 源代码
        *	public boolean desiredAssertionStatus() {
        *        ClassLoader loader = getClassLoader();
        *        // If the loader is null this is a system class, so ask the VM
        *        if (loader == null)
        *           return desiredAssertionStatus0(this);
        *                                    
        *        // If the classloader has been initialized with the assertion
        *        // directives, ask it. Otherwise, ask the VM.
        *        synchronized(loader.assertionLock) {
        *        	if (loader.classAssertionStatus != null) {
        *        		return loader.desiredAssertionStatus(getName());
        *        	}
        *       }
        *       return desiredAssertionStatus0(this);
        *   }
         * 函数功能如下：此方法返回指定类的所需的断言状态。如果要在调用此方法时将要初始化该类，则返回将分配给该类的断言状态。 如果已经设置了该类的断言状态，则返回其最新设置；
         * 如果有包默认断言状态属于此类，则返回最特殊的相关包默认断言状态的最新设置；如果该类不是系统类（即它有类加载器），则返回其类加载器的默认断言状态；否则返回系统类默认断言状态。
         * 很少有程序员需要此方法；它是为 jre 自身提供的。（它使类能够在初始化时确定是否启用断言。）注意，不保证此方法在（或将要）初始化指定类时返回与（或将与）该指定类相关的实际断言状态。
         * 返回：所需的指定类断言状态。
         */
        TestClass c = new TestClass();
        Class cls = c.getClass();
        // returns the name of the class
        String name = cls.getName();
        System.out.println("Class Name = " + name);            
        // returns assertion status
        boolean retval = cls.desiredAssertionStatus();
        System.out.println("status = " + retval);  
        
        /* 【5】
         * 源代码
         *  @CallerSensitive
         *  public static Class<?> forName(String name, boolean initialize,ClassLoader loader)
         *  throws ClassNotFoundException{
         *  	Class<?> caller = null;
         *  	SecurityManager sm = System.getSecurityManager();
         *  	if (sm != null) {
         *  		// Reflective call to get caller class is only needed if a security manager
         *  		// is present.  Avoid the overhead of making this call otherwise.
         *  		caller = Reflection.getCallerClass(); //获取到调用者的Class
         *  		if (sun.misc.VM.isSystemDomainLoader(loader)) {
         *  		ClassLoader ccl = ClassLoader.getClassLoader(caller);
         *  			if (!sun.misc.VM.isSystemDomainLoader(ccl)) {
         *  				sm.checkPermission(SecurityConstants.GET_CLASSLOADER_PERMISSION);
		 *          	}
		 *      	}
		 *      }
		 *      return forName0(name, initialize, loader, caller);
		 *  }
		 *  函数功能如下：
		 *  参数name表示的是类的全名；initialize表示是否初始化类；loader表示加载时使用的类加载器。
         * 
         */
         try {
        	 Class<?> cls1=Class.forName("liu.lang.Class.TestClass");
 			 System.out.println("Class = " + cls1.getName());
	         Class<?> class2=Class.forName("java.lang.System");
	         ClassLoader cLoader=class2.getClassLoader();
	         Class<?> cls3=Class.forName("java.lang.Thread",true,cLoader);
	         System.out.println("Class= "+class2.getName());
	         System.out.println("Class= "+cls3.getName());
         }
         catch (ClassNotFoundException e) {
        	 System.out.println(e.toString());
		}
         
        /*【6】
         * 源代码
         * public AnnotatedType[] getAnnotatedInterfaces() {
         * 		return TypeAnnotationParser.buildAnnotatedInterfaces(getRawTypeAnnotations(), getConstantPool(), this);
         * }
         * 函数功能如下：获取类所实现的与注解有关的接口类型，
         * （即以下接口类型：AnnotatedElement、AnnotatedType、AnnotatedTypeVariable、AnnotatedArrayType、
         * AnnotatedParameterizedType、AnnotatedWildcardType、GenericDeclaration、Type、TypeVariable、
         * ParameterizedType、GenericArrayType、WildcardType、Member、InvocationHandler)
         * 
         */
         try {
        	 Class<?> cls5=Class.forName("java.lang.reflect.Field"); //java.lang.Class  java.lang.Class  java.lang.reflect.AccessibleObject
        	 AnnotatedType[] arrayAn=cls5.getAnnotatedInterfaces();
        	 for(AnnotatedType ar:arrayAn) {
        		 ar.getType().getTypeName();        		 
        		 System.out.println("AnnotatedType: "+ar.getType().getTypeName());
        	 }
         }
         catch (ClassNotFoundException e) {
        	 System.out.println(e.toString());
		}

		
	}

}



























