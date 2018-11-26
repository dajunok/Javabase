package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * getParameterCount()
 * 返回该方法对象的参数个数 (无论是显式声明的还是隐式声明的或不声明的)
 * @author LIU
 *
 */
public class About_getParameterCount {
	public void test(String name, Integer age) {}

    public static void main(String[] args) throws Exception {
        Method method = About_getParameterCount.class.getDeclaredMethod("test", String.class, Integer.class);
        // 2
        System.out.println(method.getParameterCount()); //返回该方法对象的参数个数
    }
}
