package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**Method类的常用方法：
 * getTypeParameters()
 * 返回一个TypeVariable对象数组，该数组表示该方法对象声明列表上的类型变量数组
 * @author LIU
 *
 */
public class About_getTypeParameters<T,V> {
	public <T, V> void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getTypeParameters.class.getMethod("test");
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        // [T, V]
        System.out.println(Arrays.toString(typeParameters));
    }
}
