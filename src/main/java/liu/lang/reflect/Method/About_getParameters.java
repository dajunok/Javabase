package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**Method类的常用方法：
 * getParameters()
 * 返回一个参数对象数组，该数组表示该方法对象的所有参数
 * @author LIU
 *
 */
public class About_getParameters {
	public void test(String name, Integer age) {}

    public static void main(String[] args) throws Exception {
        Method method = About_getParameters.class.getDeclaredMethod("test", String.class, Integer.class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            // java.lang.String arg0
            // java.lang.Integer arg1
            System.out.println(parameter);
        }
    }
}
