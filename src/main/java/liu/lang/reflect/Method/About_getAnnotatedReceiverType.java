package liu.lang.reflect.Method;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**Method类的常用方法：
 * getAnnotatedReceiverType()
 * 返回一个AnnotatedType对象，该对象表示使用一个类型来指定该可执行对象表示的方法/构造函数的接收者类型
 * （返回方法的完整名称：  包名.类名.方法名）
 * @author LIU
 *
 */
public class About_getAnnotatedReceiverType {
	public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getAnnotatedReceiverType.class.getDeclaredMethod("test");
        AnnotatedType annotatedReceiverType = method.getAnnotatedReceiverType();
        // class liu.lang.reflect.Method.About_getAnnotatedReceiverType
        System.out.println(annotatedReceiverType.getType());
    }
}

