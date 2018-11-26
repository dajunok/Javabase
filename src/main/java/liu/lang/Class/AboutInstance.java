package liu.lang.Class;
/*
 * 1、newInstance():T		使用该类的无参构造器创建实例。
 * 2、isInstance(Object):boolean	测试该对象实例是否为该类的实例。
 * 3、cast(Object):T		把对象实例转为该类的实例。
 * 4、getEnumConstants():T[]	该类为枚举类型时，可通过此方法获取其所有枚举常量。
 * 
 */
import liu.lang.Class.AboutMethod.Parent;

public class AboutInstance {
	
	public static class Parent{
		private String name;
		private int height;
		private int age;		
		//contstructor
		public Parent() {System.out.println("OK");}		
		private Parent(String name,int height,int age) {
			this.name=name;
			this.height=height;
			this.age=age;
		}		
		public void setName(String name) {	this.name=name;	}
		public String  getName() { return name;}
		protected int getHeight() { return height; }
		private int getAge() { return age;}	
	}
	
	public static class Son extends  Parent{ }
	
	public static enum Color {  
	    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
		// 成员变量 
	    private String name;  
	    private int index;  
	    //构造方法 
	    private Color(String name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }  
	    
	} 
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//使用该类的无参构造器创建实例。
		System.out.println("(1)===========================================");
		Parent parent=Parent.class.newInstance();
		parent.setName("liulijun");
		System.out.println(parent.getName());
		
		//测试该对象实例是否为该类的实例。
		System.out.println("(2)===========================================");
		System.out.println(Parent.class.isInstance(parent));
		
		//把对象实例转为该类的实例。
		System.out.println("(3)===========================================");
		Son son=Son.class.newInstance();
		Parent parent2=Parent.class.cast(son);		//把对象实例转为该类的实例
		System.out.println(Parent.class.isInstance(parent2));
		parent2.setName("zhangSan");
		System.out.println(parent2.getName());
		
		//该类为枚举类型时，可通过此方法获取其所有枚举常量。
		System.out.println("(4)===========================================");
		Color[] colors=Color.class.getEnumConstants();
		for(Color color:colors) {
			System.out.println("索引下标："+color.index+"    "+"名称： "+color.name);
		}
	}

}



























