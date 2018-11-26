package liu.proxy.jdkproxy;

/**jdk动态代理：
 * 类HelloWorldImpl是HelloWorld接口的实现
 * @author LIU
 *
 */
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHelloWorld() {
		System.out.println("HelloWorld!");

	}

}
