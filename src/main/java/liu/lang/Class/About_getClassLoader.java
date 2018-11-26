package liu.lang.Class;



/*getClassLoader():ClassLoader	获取该类被加载时所用的类加载器。
 * 
 */
public class About_getClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(About_getClassLoader.class.getClassLoader().toString());
	}

}
