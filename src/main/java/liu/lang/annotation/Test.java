package liu.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



@TestAnnotation(msg="hello")
public class Test {
	@Check("aaa")
    public int a;


    @Perform
    public void testMethod(){}


    @SuppressWarnings("deprecation")
    public void test1(){
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean hasAnnotation=Test.class.isAnnotationPresent(TestAnnotation.class);
		
		 if ( hasAnnotation ) {
			 	Class<Test> cl=Test.class;
			 	Class<?> cl2 = Class.forName("SuperMan");			    
	            TestAnnotation testAnnotation = cl.getAnnotation(TestAnnotation.class);
	            System.out.println("id:"+testAnnotation.id());
	            System.out.println("msg:"+testAnnotation.msg());
	        }
		 
		 try {
	            Field a = SuperMan.class.getField("a");
	            a.setAccessible(true);
	            //获取一个成员变量上的注解
	            Check check=a.getAnnotation(Check.class);
	            
 
	            if ( check !=null ) {
	                System.out.println("check value:"+check.value());
	            }

	            Method testMethod = Test.class.getDeclaredMethod("testMethod");

	            if ( testMethod != null ) {
	            	// 获取方法中的注解
	                Annotation[] ans = testMethod.getAnnotations();
	                for( int i = 0;i < ans.length;i++) {
	                    System.out.println("method testMethod annotation:"+ans[i].annotationType().getSimpleName());
	                }
	            }
	        } catch (NoSuchFieldException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        } catch (SecurityException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        } catch (NoSuchMethodException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	}

}
