package liu.lang.Class;

import java.util.ArrayList;
import java.util.List;


interface Fruit {  }
class Apple implements Fruit { 
	public class InnerApple{}
} 

/**获取Class对应的对象名称，Class不是单纯的指class定义的类，它是包括基本数据类型和数组，还包括class，interface，@interface，enum等定义出来的类型。
 * getName():String
 * getCanonicalName():String
 * getSimpleName():String
 * forName(String):Class<?>
 * forName(String, boolean, ClassLoader):Class<?>
 * 
 *
 */
public class AboutName {

	public static void main(String[] args) throws ClassNotFoundException {
		Fruit apple=new Apple();
		System.out.println("(1)=================================================");
        System.out.println(apple.getClass().getCanonicalName());//返回com.test.Apple  
        System.out.println(apple.getClass().getSimpleName());//Apple  
        System.out.println(apple.getClass().getName());//返回com.test.Apple   
        
         
        Apple[] arrApple=new Apple[]{};  
        System.out.println("(2)=================================================");
        System.out.println(arrApple.getClass().getCanonicalName());//返回com.test.Apple[]  
        System.out.println(arrApple.getClass().getSimpleName());//返回Apple[] 
        System.out.println(arrApple.getClass().getName());//返回[Lcom.test.Apple; 
        
        
        System.out.println("(3)=================================================");
        System.out.println(String.class.getCanonicalName());//返回java.lang.String  
        System.out.println(String.class.getSimpleName());//返回String 
        System.out.println(String.class.getName());//返回java.lang.String
        
        
        System.out.println("(4)=================================================");
        System.out.println(int.class.getCanonicalName());//返回int  
        System.out.println(int.class.getSimpleName());//返回int  
        System.out.println(int.class.getName());//返回int 
        
        
        Apple a1=new Apple();  
        Apple a2=new Apple();  
        List<Apple> appleList=new ArrayList<Apple>();  
        appleList.add(a1);  
        appleList.add(a2);  
        System.out.println("(5)=================================================");
        System.out.println(appleList.getClass().getCanonicalName());//返回java.util.ArrayList  
        System.out.println(appleList.getClass().getSimpleName());//返回ArrayList
        System.out.println(appleList.getClass().getName());//返回java.util.ArrayList 
        
        System.out.println("(6)=================================================");
        String str=Class.forName("liu.lang.Class.AboutName").getName();
        String str1=Class.forName("liu.lang.Class.AboutName").getSimpleName();
        String str2=Class.forName("liu.lang.Class.Apple").getName();
        String str3=Class.forName("liu.lang.Class.Apple").getSimpleName();
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        
        System.out.println("(7)=================================================");
        Class<?> clazz=Class.forName("liu.lang.Class.Apple$InnerApple");
        String str4=clazz.getName();
        String str5=clazz.getCanonicalName();
        String str6=clazz.getSimpleName();
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        
	}

}


