package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

/**Method类的常用方法：
 * getParameterTypes()
 * 返回一个Class对象数组，该数组以声明顺序表示该方法对象的参数对象，会擦除泛型
 * @author LIU
 *
 */
public class About_getParameterTypes<T> {
	public void test(T t) {}

    public void test(LinkedList<Integer> list) {}

    public static void main(String[] args) throws Exception {
        Method objectMethod = About_getParameterTypes.class.getMethod("test", Object.class);
        Method listMethod = About_getParameterTypes.class.getMethod("test", LinkedList.class);

        Class<?>[] objectParameterTypes = objectMethod.getParameterTypes();
        // [class java.lang.Object]
        System.out.println(Arrays.toString(objectParameterTypes));
        Class<?>[] listParameterTypes = listMethod.getParameterTypes();
        // [class java.util.LinkedList]
        System.out.println(Arrays.toString(listParameterTypes));
    }
}
