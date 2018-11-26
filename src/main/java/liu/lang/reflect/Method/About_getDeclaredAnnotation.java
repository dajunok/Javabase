package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * getDeclaredAnnotation(Class<T> annotationClass)
 * 如果该方法对象存在指定类型的注解，则返回该注解，否则返回null
 * 只有类级别的注解会被继承得到，对于其他对象而言，getAnnotation() 方法与 getDeclaredAnnotation() 方法作用相同
 * @author LIU
 *
 */
public class About_getDeclaredAnnotation {
	@MethodAnnotation(key = "key", value = "value")
    public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getDeclaredAnnotation.class.getDeclaredMethod("test");
        MethodAnnotation annotation = method.getDeclaredAnnotation(MethodAnnotation.class);
        // @liu.lang.reflect.Method.MethodAnnotation(key=key, value=value)
        System.out.println(annotation);
    }
}
