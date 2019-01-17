package liu.java.util.AbstractCollection.AbstractSet.EnumSet;

import java.util.EnumSet;



public class TestEnumSet {
	 
	    public static void main(String[] args) {
	        //1.创建一个包含Session（枚举类）里所有枚举值的EnumSet集合
	        EnumSet<Session> e1 = EnumSet.allOf(Session.class);
	        System.out.println(e1);//[SPRING, SUMMER, FAIL, WINTER]
	 
	        //2.创建一个空EnumSet
	        EnumSet<Session> e2 = EnumSet.noneOf(Session.class);
	        System.out.println(e2);//[]
	 
	        //3. add()空EnumSet集合中添加枚举元素
	        e2.add(Session.SPRING);
	        e2.add(Session.SUMMER);
	        System.out.println(e2);//[SPRING, SUMMER]
	 
	        //4. 以指定枚举值创建EnumSet集合
	        EnumSet<Session> e3 = EnumSet.of(Session.SPRING,Session.FAIL);
	        System.out.println(e3);//[SPRING, FAIL]
	        
	        EnumSet<Color> e7=EnumSet.noneOf(Color.class);
	        e7.add(Color.BLUE);	        
	        System.out.println("E7："+e7);//E7：[BLUE]
	        
	        System.out.println("E2："+e2);//[SPRING, SUMMER]
	        //含指定集合中不包含的此类型的所有元素。
	        EnumSet<Session> e8=e7.complementOf(e2);
	        System.out.println("E8："+e8);//E8：[FAIL, WINTER]
	 
	        //5.创建一个包含从from枚举值到to枚举值范围内所有枚举值的EnumSet集合。
	        EnumSet<Session> e4 = EnumSet.range(Session.SPRING,Session.FAIL);
	        System.out.println(e4);//[SPRING, SUMMER, FAIL]
	 
	        //6.创建一个其元素类型与指定EnumSet里元素类型相同的EnumSet集合，
	        //  新EnumSet集合包含原EnumSet集合所不包含的枚举值
	        EnumSet<Session> e5 = EnumSet.complementOf(e4);
	        System.out.println(e5);//[WINTER]
	        
	        //Enum<E>与enum关键字的关系
	        Enum<Color> enum1=Color.BLUE;
	        System.out.println("enum1："+enum1);//[WINTER]
	    }

	 
		//创建一个枚举
		enum Session{
		    SPRING,
		    SUMMER,
		    FAIL,
		    WINTER
		}
		
		enum Color{
		    	RED,
		    	WHITE,
		    	GREEN,
		    	BLUE
		}
	


}
