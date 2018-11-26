package liu.lang.reflect.Method;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**Method类的常用方法：
 * getAnnotatedReturnType()  
 * 返回一个AnnotatedType对象，该对象表示使用一个类型来指定由该可执行文件表示的方法/构造函数的返回类型 
 * （返回方法的返回值类型）
 * @author LIU
 *
 */
public class About_getAnnotatedReturnType {

	public String test() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = About_getAnnotatedReturnType.class.getDeclaredMethod("test");
        AnnotatedType methodAnnotatedReturnType = method.getAnnotatedReturnType();
        // class java.lang.String
        System.out.println(methodAnnotatedReturnType.getType());
    }
}
