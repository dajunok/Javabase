package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isAccessible()
 * 获取该方法对象的可访问标志
 * @author LIU
 *
 */
class MethodTest {

    private void test() {}  //私有方法，不可访问
}
public class About_isAccessible {
	public static void main(String[] args) throws Exception {
        Method method = MethodTest.class.getDeclaredMethod("test");
        // false
        System.out.println(method.isAccessible());
    }
}
