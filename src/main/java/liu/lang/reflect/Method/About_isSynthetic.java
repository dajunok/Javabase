package liu.lang.reflect.Method;

import java.lang.reflect.Method;

/**Method类的常用方法：
 * isSynthetic()
 * 判断该方法对象是否为合成方法，如果是则返回true，否则为false
 * 在内部类InnerClass中，name是一个私有属性，而我们在外部类MethodTest中，直接引用了这个属性，
 * 因此编译器通过生成一个合成方法，用于绕开private私有属性的限制
 * 
 * 注：
 * 有关synthetic的相关内容，小伙伴可以看下这里Java 中冷门的 synthetic 关键字原理解读
 * https://www.cnblogs.com/bethunebtj/p/7761596.html
 * @author LIU
 *
 */
public class About_isSynthetic {
	private class InnerClass {
        private String name = "小明";
    }

    public static void main(final String[] arguments) {
        InnerClass innerClass = new About_isSynthetic().new InnerClass();
        System.out.println("name: " + innerClass.name);

        Method[] declaredMethods = innerClass.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //

            System.out.println("【" + declaredMethod + "】" + " isSynthetic(): " + declaredMethod.isSynthetic());
        }
        /*输出：
         * 【static java.lang.String liu.lang.reflect.Method.About_isSynthetic
         * $InnerClass.access$1(liu.lang.reflect.Method.About_isSynthetic$InnerClass)】 
         * isSynthetic(): true
         */
    }
}
