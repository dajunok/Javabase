package liu.lang.reflect.Method;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**Method类的常用方法：
 * getAnnotatedParameterTypes()
 * 返回一个AnnotatedType对象数组，这些对象表示使用类型来指定由该可执行文件表示的方法/构造函数的形式参数类型
 * @author LIU
 *
 */
public class About_getAnnotatedParameterTypes {
	public void test(String name, Integer age) {}

    public static void main(String[] args) throws Exception {
        Method method = About_getAnnotatedParameterTypes.class.getDeclaredMethod("test", String.class, Integer.class);
        AnnotatedType[] annotatedParameterTypes = method.getAnnotatedParameterTypes();
        for (AnnotatedType annotatedParameterType : annotatedParameterTypes) {
            // class java.lang.String
            // class java.lang.Integer
            System.out.println(annotatedParameterType.getType());
        }
    }
}
