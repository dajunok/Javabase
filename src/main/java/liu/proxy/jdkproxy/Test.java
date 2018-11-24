package liu.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		HelloWorld helloWorld=new HelloWorldImpl();
		InvocationHandler handler=new HelloWorldHandler(helloWorld);  //将原始对象传入调用句柄
		
		//创建动态代理对象
		HelloWorld proxy=(HelloWorld)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), 
															helloWorld.getClass().getInterfaces(),
															handler);
		proxy.sayHelloWorld();		

	}

}
