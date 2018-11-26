package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * getName()  返回方法对象名称
 * @author LIU
 *
 */
public class About_getName {
	public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getName.class.getDeclaredMethod("test");
        // test
        System.out.println(method.getName());
    }
}
