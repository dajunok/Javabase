package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**Method类的常用方法：
 * getGenericExceptionTypes()
 * 返回一个Type对象数组，该数组表示由该方法对象抛出的异常类型，会保留泛型
 * @author LIU
 *
 */
public class About_getGenericExceptionTypes<T> {
	public <T extends Exception> void test() throws T, NullPointerException {}

    public static void main(String[] args) throws Exception {
        Method method = About_getGenericExceptionTypes.class.getMethod("test");
        Type[] genericExceptionTypes = method.getGenericExceptionTypes();
        // [T, class java.lang.NullPointerException]
        System.out.println(Arrays.toString(genericExceptionTypes));
    }
}
