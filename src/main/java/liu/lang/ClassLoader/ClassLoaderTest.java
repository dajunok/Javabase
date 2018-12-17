package liu.lang.ClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ClassLoaderTest {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //创建自定义classloader对象。	
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\ETong\\java\\lib");
        try {
            //加载class文件
            Class<?> c = diskLoader.loadClass("liu.lang.ClassLoader.HelloWorld");
            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("getName",null);
                    Method method1 = c.getDeclaredMethod("setName",String.class);
                    //通过反射调用HelloWorld类的getName方法
                    method1.invoke(obj, "liulijun!!");
                    String name=(String) method.invoke(obj, null);
                    System.out.println(name);
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block        	
            e.printStackTrace();
        }       
	}
}











