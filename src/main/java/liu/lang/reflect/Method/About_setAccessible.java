package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * setAccessible(boolean flag)
 * 设置该方法对象的可访问标志
 * 在其他类里调用该方法对象时，如果该方法为私有方法，需要设置访问标志为true，否则会报异常
 * @author LIU
 *
 */
class MethodTestt {

    private void test() {}
}
public class About_setAccessible {
	public static void main(String[] args) throws Exception {
        Method method = MethodTestt.class.getDeclaredMethod("test");
        method.setAccessible(true);//设置访问标志为true
        // test
        System.out.println(method.getName());
    }
}
