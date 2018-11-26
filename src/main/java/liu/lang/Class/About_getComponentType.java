package liu.lang.Class;

class Test{}


public class About_getComponentType {
	public static void main(String[] args) {
		
		//该类为数组类型时，可通过getComponentType()方法获取其组件类型。
		System.out.println(int[].class.getComponentType());
	    System.out.println(int[][].class.getComponentType());
	    System.out.println(Test[].class.getComponentType().getName());
	    System.out.println(Test[].class.getComponentType().getSimpleName()); 
	}

}
