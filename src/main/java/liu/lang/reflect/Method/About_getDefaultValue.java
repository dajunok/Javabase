package liu.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**Method类的常用方法：
 * getDefaultValue()
 * 返会该注解方法对象表示的成员默认值
 * 如果成员属于基本数据类型，则返回对应的包装类实例
 * 如果没有默认值或者该方法实例不表示注解方法，则返回null
 * @author LIU
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation1 {
    String key() default "default key";
    String value() default "default value";
}

public class About_getDefaultValue {
	public static void main(String[] args) throws Exception {
        Method key = MethodAnnotation1.class.getMethod("key");
        Method value = MethodAnnotation1.class.getMethod("value");
        Object defaultValue1 = key.getDefaultValue();
        Object defaultValue2 = value.getDefaultValue();
        // default key
        System.out.println(defaultValue1);
        // default value
        System.out.println(defaultValue2);
    }
}
