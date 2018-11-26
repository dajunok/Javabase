package liu.lang.reflect.Method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**Method类的常用方法：
 * getModifiers()   返回包含修饰符的数组（包括status、public、private、final等等）
 * 返回修饰该方法对象修饰符的整数形式，使用 Modifier 类对其进行解码
 * @author LIU
 *
 */
public class About_getModifiers {
	public static void test() {}

    public static void main(String[] args) throws Exception {
        Method method = About_getModifiers.class.getDeclaredMethod("test");
        //public static
        System.out.println(Modifier.toString(method.getModifiers()));
    }
}

