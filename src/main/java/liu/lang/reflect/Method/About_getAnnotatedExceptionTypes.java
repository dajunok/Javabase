package liu.lang.reflect.Method;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**Method类的常用方法：
 * getAnnotatedExceptionTypes()  
 * 返回一个AnnotatedType对象数组，这些对象表示使用类型来指定由该可执行文件表示的方法/构造函数声明的异常
 * （返回方法的异常类型）
 * @author LIU
 *
 */
public class About_getAnnotatedExceptionTypes {
	
	public void test() throws NullPointerException, ClassNotFoundException {}  //带有异常抛出的方法
	
	public static void main(String[] args) throws Exception {
        Method method = About_getAnnotatedExceptionTypes.class.getDeclaredMethod("test");
        AnnotatedType[] annotatedExceptionTypes = method.getAnnotatedExceptionTypes();
        for (AnnotatedType annotatedExceptionType : annotatedExceptionTypes) {
            // class java.lang.NullPointerException
            // class java.lang.ClassNotFoundException
            System.out.println(annotatedExceptionType.getType());
        }
    }

}
