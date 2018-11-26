package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isAnnotationPresent(Class<? extends Annotation> annotationClass)
 * 如果该方法对象上有指定类型的注解，则返回true，否则为false
 * @author LIU
 *
 */
public class About_isAnnotationPresent {
	@Check
    public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_isAnnotationPresent.class.getDeclaredMethod("test");
        // true
        System.out.println(method.isAnnotationPresent(Check.class));  //判断该方法是否有@Check注解
    }
}
