package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * getReturnType()
 * 返回一个Class对象，该Class对象表示该方法对象的返回对象，会擦除泛型
 * @author LIU
 *
 */
public class About_getReturnType<T> {
	public T test(T t) {
        return t;
    }

    public static void main(String[] args) throws Exception {
        Method method = About_getReturnType.class.getMethod("test", Object.class);
        Class<?> returnType = method.getReturnType();
        // class java.lang.Object
        System.out.println(returnType);
    }
}
