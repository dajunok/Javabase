package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isVarArgs()  如果该方法对象的参数中存在 可变参，则返回true，否则为false
 * @author LIU
 *
 */
public class About_isVarArgs {
	public void test(String ... args) {}

    public static void main(String[] args) throws Exception {
        Method method = About_isVarArgs.class.getDeclaredMethod("test", String[].class);
        // true
        System.out.println(method.isVarArgs());  //如果该方法对象的参数中存在 可变参，则返回true，否则为false
    }
}
