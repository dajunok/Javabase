package liu.lang.ClassLoader;

/*loadClass():Class<?>    通过指定的全限定类名加载class，它通过同名的loadClass(String,boolean)方法。 
 * 
 */
public class AboutClassLoader {

	public static void main(String[] args) {
		ClassLoader cl = AboutClassLoader.class.getClassLoader();
        cl = AboutClassLoader.class.getClassLoader();
        System.out.println("ClassLoader is:"+cl.toString());
        System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
        System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());
        


	}

}
