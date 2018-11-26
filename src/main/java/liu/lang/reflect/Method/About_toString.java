package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * toString()
 * 返回该方法对象的字符串表示形式，会擦除泛型
 * @author LIU
 *
 */
public class About_toString {
	public <T, V> void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_toString.class.getMethod("test");
        // public void liu.lang.reflect.Method.About_toString.test()
        System.out.println(method.toString());
    }
}
