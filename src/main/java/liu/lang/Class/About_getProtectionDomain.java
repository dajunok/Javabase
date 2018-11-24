package liu.lang.Class;

import java.net.URL;

/*getProtectionDomain():ProtectionDomain	一种权限机制，指定一个代码源所拥有的权限集合，保护域就是代表一个代码源的权限集合。
 * 
 */
public class About_getProtectionDomain {
	public static void main(String[] args) {
		System.out.println(About_getProtectionDomain.class.getProtectionDomain().toString());
		URL url = About_getProtectionDomain.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(url);
	}
	
}
