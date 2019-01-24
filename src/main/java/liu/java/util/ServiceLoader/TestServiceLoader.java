package liu.java.util.ServiceLoader;

import java.util.ServiceLoader;

/**
 * 
 * @author LIU
 *	ServiceLoader：服务加载器
 *	它的实现原理是通过一个配置文件将接口或抽象类的所有实现类（子类）的实例加载到一个容器中（就是ServiceLoader对象）
 *	注意事项：
 *	1、配置文件的命名必须是接口（或抽象类）的全限定名，例如本案例：liu.java.util.ServiceLoader.Animal
 *	2、配置文件需放置到	\target\classes\META-INF\services	目录下。
 */

public class TestServiceLoader {
	
	public static void main(String[] args) {
		ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);    
		for(Animal animal:serviceLoader) {
			animal.eat();
		}
	}
	


}




