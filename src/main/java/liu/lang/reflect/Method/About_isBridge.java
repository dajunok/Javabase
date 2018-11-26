package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isBridge()
 * 判断该方法对象是否桥接方法，如果是则返回true，否则为false
 * 
 * 注：
 * 桥接方法: 是 JDK1.5 引入泛型后，为了使Java的泛型方法生成的字节码和 1.5 版本前的字节码相兼容，由编译器自动生成的方法
 * 有关bridge的相关内容，小伙伴可以看下这里
 * https://blog.csdn.net/mhmyqn/article/details/47342577
 * @author LIU
 *
 */
interface Interfacee<T> {
    T test(T t);
}


public class About_isBridge implements Interfacee<String> {
	@Override
    public String test(String str) {
        return str;
    }

    public static void main(final String[] arguments) {
        Method[] declaredMethods = About_isBridge.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //【public static void liu.lang.reflect.Method.About_isBridge.main(java.lang.String[])】 isBridge(): false
            //【public java.lang.String liu.lang.reflect.Method.About_isBridge.test(java.lang.String)】 isBridge(): false
            //【public java.lang.Object liu.lang.reflect.Method.About_isBridge.test(java.lang.Object)】 isBridge(): true
            System.out.println("【" + declaredMethod + "】" + " isBridge(): " + declaredMethod.isBridge());
        }
    }
}