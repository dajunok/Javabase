package liu.lang.Class;

import java.lang.reflect.Method;

public class AboutMethod {
	
	/*方法（函数）
	 * 1、getMethod(String, Class<?>...):Method  返回问权限是public的方法(通过参数过滤指定某一个具体方法),子类继承了父类方法，因此可以通过子类获取父类方法
	 * 2、getMethods():Method[]                  返回问权限是public的所有方法。子类继承了父类方法，因此可以通过子类获取父类方法
	 * 3、getDeclaredMethod(String, Class<?>...):Method  通过参数过滤指定某一个具体方法（可以是任何访问权限public、protected或者private），但不能获取继承得来的方法
	 * 4、getDeclaredMethods():Method[]  返回所有方法，包括public的和非public的，当然也包括private的。但不能获取继承得来的方法
	 */
	
	public static class Parent{
		private String name;
		private int height;
		private int age;
		
		public void setName(String name) {	this.name=name;	}
		public String  getName() { return name;}
		protected int getHeight() { return height; }
		private int getAge() { return age;}	
	}
	
	public static class Son extends  Parent{
		private String hobby;
		
		public String getHobby() {return hobby;}
	}
	
	public static class Grandson extends Son{
		private boolean sing;
		
		private void setSing(boolean isNy) {sing=isNy;}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//返回问权限是public的方法(通过参数过滤指定某一个具体方法)
		System.out.println("(1)===========================================");
		System.out.println(Parent.class.getMethod("getName", null));
		System.out.println(Parent.class.getMethod("setName", String.class));
		System.out.println(Son.class.getMethod("getName", null)); //子类继承了父类方法，因此可以通过子类获取父类方法
		System.out.println(Son.class.getMethod("getName", null));
		
		//返回问权限是public的所有方法,包括继承得来的方法。
		System.out.println("(2)===========================================");
		Method[] methods=Parent.class.getMethods();
		for(Method met:methods) {
			System.out.println(met);
		}
		
		//通过参数过滤指定某一个具体方法（可以是任何访问权限public、protected或者private）,但不能获取继承得来的方法,只能获取本类声明的方法
		System.out.println("(3)===========================================");
		System.out.println(Parent.class.getDeclaredMethod("getName", null));
		System.out.println(Parent.class.getDeclaredMethod("setName", String.class));
		System.out.println(Parent.class.getDeclaredMethod("getAge",null));
		System.out.println(Grandson.class.getDeclaredMethod("setSing", boolean.class));
		
		//返回问权限是public的所有方法,包括继承得来的方法。 返回所有方法，包括public的和非public的，当然也包括private的。但不能获取继承得来的方法,只能获取本类声明的方法
		System.out.println("(4)===========================================");
		Method[] methodss=Grandson.class.getDeclaredMethods();
		for(Method met:methodss) {
			System.out.println(met);
		}
	}

}
