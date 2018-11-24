package liu.lang.Class;

/* getSigners():Object[]  此方法返回这个类的签名，或者为null，如果没有签名，如果这个对象表示一个基本类型或void，则返回null。
 * 一种盖章机制，编写者编写完代码后，由签名者审核确认无误后，进行签名，同一代码可以由多个签名者审核后盖章。
 * 
 */
public class About_getSigners {

	public static void main(String[] args) {
		Object[] objects=Package.class.getSigners();
		for(Object object:objects) {
			System.out.println(object.toString());
		}
		
	}
	
}
