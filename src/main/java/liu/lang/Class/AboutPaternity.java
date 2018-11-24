package liu.lang.Class;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;



/**继承关系：
 * 1、getSuperclass():Class<? super T>	获取继承的父类。
 * 2、getGenericSuperclass():Type		获取当前对象的直接超类的 Type
 * 3、getAnnotatedSuperclass():AnnotatedType  返回AnnotatedType对象，该对象表示使用类型来指定此Class对象所表示的实体的超类
 * 4、getInterfaces():Class<?>[]		获取实现的接口集。
 * 5、getGenericInterfaces():Type[]  获取实现的接口集。
 * 6、getAnnotatedInterfaces():AnnotatedType[]
 * 7、asSubclass(Class<U>):Class<? extends U>	把该类型(子类)转换为目标类型(父类)。
 * 8、isAssignableFrom(Class<?>):boolean	测试该类型(父类)是否为目标类型(子类)的父类。
 * 9、getClasses():Class<?>[]  获取该类及其父类所有的public的内部类。
 * 10、getDeclaredClasses():Class<?>[]  获取该类所有的内部类，除去父类的
 */

public class AboutPaternity {
	class Parent<T>{}
	class Son extends  Parent<Integer>{}
	class Grandson extends Son implements  TestInter{	}

	
	@Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnnotation { }
	

	public interface  TestInter{}

	public static void main(String[] args) throws ClassNotFoundException {
		//获取继承的父类。
		System.out.println("(1)===========================================");
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Grandson").getSuperclass().getName());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Grandson").getSuperclass().getSimpleName());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").getSuperclass().getSimpleName());
		
		//获取当前对象的直接超类的 Type
		System.out.println("(2)===========================================");
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").getGenericSuperclass());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").getGenericSuperclass().getTypeName());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Grandson").getGenericSuperclass().getTypeName());
		
		//返回AnnotatedType对象，该对象表示使用类型来指定此Class对象所表示的实体的超类
		System.out.println("(3)===========================================");
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").getAnnotatedSuperclass());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").getAnnotatedSuperclass().getType());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Grandson").getAnnotatedSuperclass());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Grandson").getAnnotatedSuperclass().getType());
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$TestAnnotation").getAnnotatedSuperclass());
		
		//获取实现的接口集。返回Class<?>[]
		System.out.println("(4)===========================================");
		Class<?>[] clsarr=Class.forName("liu.lang.Class.AboutPaternity$Grandson").getInterfaces();
		for(Class<?> clzz:clsarr) {
			System.out.println(clzz.getName());
		}
		
		//获取实现的接口集。返回Type[]
		System.out.println("(5)===========================================");
		Class<?>[] arrtype=(Class<?>[]) Class.forName("liu.lang.Class.AboutPaternity$Grandson").getGenericInterfaces();
		for(Class<?> clzz:arrtype) {
			System.out.println(clzz.getName());
		}

		//获取实现的接口集。返回AnnotatedType[]
		System.out.println("(6)===========================================");
		AnnotatedType[] arrAnnot=(AnnotatedType[]) Class.forName("liu.lang.Class.AboutPaternity$Grandson").getAnnotatedInterfaces();
		for(AnnotatedType antype:arrAnnot) {
			System.out.println(antype.getType().getTypeName());
		}
		
		//把该类型(子类)转换为目标类型(父类)
		System.out.println("(7)===========================================");
		Class.forName("liu.lang.Class.AboutPaternity$Grandson").asSubclass(Parent.class);
		
		//判断该类型(父类)是否为目标类型(子类)的父类(如果是目标类所实现的接口也返回true)。
		System.out.println("(8)===========================================");
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Parent").isAssignableFrom(Grandson.class));
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$Son").isAssignableFrom(Grandson.class));
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$TestInter").isAssignableFrom(Grandson.class));
		System.out.println(Class.forName("liu.lang.Class.AboutPaternity$TestAnnotation").isAssignableFrom(Grandson.class));
		System.out.println(Class.forName("java.lang.annotation.Annotation").isAssignableFrom(TestAnnotation.class));
		
		//获取该类及其父类所有的public的内部类
		System.out.println("(9)===========================================");
		Class<?>[] arryclz=AboutPaternity.class.getClasses();
		for(Class<?> clz:arryclz) {
			System.out.println(clz.getName());
		}
		
		// 获取该类所有的内部类，除去父类的
		System.out.println("(10)===========================================");
		Class<?>[] arryDeclar=AboutPaternity.class.getDeclaredClasses();
		for(Class<?> clz:arryDeclar) {
			System.out.println(clz.getName());
		}
	}

}

