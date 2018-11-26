package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * toGenericString()
 * 返回该方法对象的字符串表示形式，会保留泛型
 * @author LIU
 *
 */
public class About_toGenericString {
	public <T, V> void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_toGenericString.class.getMethod("test");
        // public <T,V> void liu.lang.reflect.Method.About_toGenericString.test()
        System.out.println(method.toGenericString());
    }
}
