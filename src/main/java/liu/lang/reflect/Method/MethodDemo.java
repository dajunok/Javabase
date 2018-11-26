package liu.lang.reflect.Method;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**java反射：Method对象
 * 
 * @author LIU
 *
 */
public class MethodDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Student student=new Student();   //创建Student实例
		Class<?> cl=student.getClass();  //获取Student.class对象
		System.out.println(cl);
		
		try {
			System.out.println("(1)===========================================");
			Method method=cl.getMethod("peClass", String.class);  //获取Student类的peClass方法
			Object result=method.invoke(student, "体育老师");  //调用peClass方法
			System.out.println("上课人数："+result);
			
			//获取方法的返回值类型：getReturnType()
			System.out.println("(2)===========================================");
			Object returntype= method.getReturnType();  
			System.out.println("返回值类型："+returntype);			
			AnnotatedType methodAnnotatedReturnType=method.getAnnotatedReturnType();
			System.out.println("【AnnotatedType】返回值类型："+methodAnnotatedReturnType.getType());
			
			//获取修饰符：getModifiers()
			System.out.println("(3)===========================================");
			int m=method.getModifiers();  //获取修饰符数值
			System.out.println("函数："+method.getName()+" "+"修饰符："+Modifier.toString(m)+"  "+m);
			
			//获取private私有方法：getDeclaredMethod
			System.out.println("(4)===========================================");
			Method method2=cl.getDeclaredMethod("mathClass", String.class);
			method2.setAccessible(true); //取消权限控制检查，使private成员可以被访问、修改
			m=method2.getModifiers();//获取修饰符数值
			System.out.println("函数："+method2.getName()+" "+"修饰符："+Modifier.toString(m)+"  "+m);
		
			//
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
