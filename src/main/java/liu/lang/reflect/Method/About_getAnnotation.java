package liu.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation {

    String key();

    String value();
}

/**Method类的常用方法：
 * getAnnotation(Class<T> annotationClass)
 * 如果该方法对象存在指定类型的注解，则返回该注解，否则返回null
 * 只有类级别的注解会被继承得到，对于其他对象而言，getAnnotation() 方法与 getDeclaredAnnotation() 方法作用相同
 * @author LIU
 *
 */
public class About_getAnnotation {
    
    @MethodAnnotation(key = "key", value = "value")
    public void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getAnnotation.class.getDeclaredMethod("test");
        MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
        // @liu.lang.reflect.Method.MethodAnnotation(key=key, value=value)
        System.out.println(annotation);
    }
}


