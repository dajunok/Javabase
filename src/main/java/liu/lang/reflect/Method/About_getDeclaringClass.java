package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * getDeclaringClass()
 * 返回该方法对象表示的方法所在类的Class对象
 * @author LIU
 *
 */
public class About_getDeclaringClass {
	public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getDeclaringClass.class.getDeclaredMethod("test");
        Class<?> declaringClass = method.getDeclaringClass();
        // class liu.lang.reflect.Method.About_getDeclaringClass
        System.out.println(declaringClass);  //返回该方法对象表示的方法所在类的Class对象
    }
}