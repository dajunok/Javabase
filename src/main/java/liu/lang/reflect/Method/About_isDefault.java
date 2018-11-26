package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isDefault()
 * 判断该方法对象是否为默认方法，如果是则返回true，否则为false
 * @author LIU
 *
 */
interface Interface {
	//接口带默认方法实体
    default void test() {  
        System.out.println("这是一个默认方法");
    }
}

public class About_isDefault implements Interface{
	public static void main(String[] args) throws Exception {
        Method method = About_isDefault.class.getMethod("test");
        // true
        System.out.println(method.isDefault());  //判断该方法对象是否为默认方法
    }
}
