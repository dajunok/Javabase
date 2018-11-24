package liu.lang.Class;

import java.lang.reflect.Field;

import liu.lang.Class.AboutMethod.Parent;
import liu.lang.Class.AboutMethod.Son;

public class AboutField {
	/*类域（字段）
	 * 	1、getField(String):Field    返回问权限是public的类域(通过名称指定某一个具体类域),子类继承了父类方法，因此可以通过子类获取父类类域
	 *	2、getFields():Field[]       返回访问权限是public的所有类域。子类继承了父类方法，因此可以通过子类获取父类类域
	 * 	3、getDeclaredField(String):Field   通过名称指定某一个具体类域（可以是任何访问权限public、protected或者private），但不能获取继承得来的类域
	 *	4、getDeclaredFields():Field[]	       返回所有类域，包括public的和非public的，当然也包括private的。但不能获取继承得来的类域
	 *
	 */
	public static class Parent{
		private String name;
		private int height;
		public int age;
		public int sex;
		
		public void setName(String name) {	this.name=name;	}
		public String  getName() { return name;}
		protected int getHeight() { return height; }
		private int getAge() { return age;}	
	}
	
	public static class Son extends  Parent{
		private String hobby;
		public String educational;
		
		public String getHobby() {return hobby;}
	}
	
	public static class Grandson extends Son{
		private boolean sing;
		
		private void setSing(boolean isNy) {sing=isNy;}
	}
	
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		//返回问权限是public的类域(通过名称指定某一个具体类域),子类继承了父类方法，因此可以通过子类获取父类类域
		System.out.println("(1)===========================================");		
		System.out.println(Parent.class.getField("age"));
		System.out.println(Son.class.getField("age"));  ////子类继承了父类方法，因此可以通过子类获取父类类域
		System.out.println(Grandson.class.getField("age"));  //子类继承了父类方法，因此可以通过子类获取父类类域
		
		//返回访问权限是public的所有类域。子类继承了父类方法，因此可以通过子类获取父类类域
		System.out.println("(2)===========================================");
		Field[] fields=Son.class.getFields();
		for(Field field:fields) {
			System.out.println(field);
		}
		
		//通过名称指定某一个具体类域（可以是任何访问权限public、protected或者private），但不能获取继承得来的类域
		System.out.println("(3)===========================================");
		System.out.println(Parent.class.getDeclaredField("name"));
		System.out.println(Parent.class.getDeclaredField("age"));
		System.out.println(Parent.class.getDeclaredField("sex"));
		System.out.println(Son.class.getDeclaredField("hobby"));  
		System.out.println(Grandson.class.getDeclaredField("sing")); 
		
		//返回所有类域，包括public的和非public的，当然也包括private的。但不能获取继承得来的类域
		System.out.println("(4)===========================================");
		Field[] fieldss=Parent.class.getDeclaredFields();
		for(Field field:fieldss) {
			System.out.println(field);
		}
	}
}
