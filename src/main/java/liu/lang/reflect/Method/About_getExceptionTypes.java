package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.util.Arrays;

/**Method类的常用方法：
 * getExceptionTypes()
 * 返回一个Class对象数组，该数组表示由该方法对象抛出的异常对象，会擦除泛型
 * @author LIU 
 * @param <T>
 */
public class About_getExceptionTypes<T> {
	public <T extends Exception> void test() throws T, NullPointerException {}

    public static void main(String[] args) throws Exception {
        Method method = About_getExceptionTypes.class.getMethod("test");
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        // [class java.lang.Exception, class java.lang.NullPointerException]
        System.out.println(Arrays.toString(exceptionTypes));
    }
}
