package liu.lang.reflect.Method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**Method类的常用方法：
 * getParameterAnnotations()
 * 返回一组注解数组，这些注解以声明顺序修饰该方法对象的参数
 * @author LIU
 *
 */
public class About_getParameterAnnotations {
	public void test(@Check(value="zhangsan") String name,
			@Check(value="Lisi") Integer age) {}

	public static void main(String[] args) throws Exception {
		Method method = About_getParameterAnnotations.class.getDeclaredMethod("test", String.class, Integer.class);
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		//[[@liu.lang.reflect.Method.Check(value=zhangsan)], [@liu.lang.reflect.Method.Check(value=Lisi)]]
		System.out.println(Arrays.deepToString(parameterAnnotations));
	}
}
