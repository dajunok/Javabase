package liu.proxy.cglib.case_1;

public class Test {
	public static void main(String[] args) throws Exception {
		Hello hello = new Hello();
		ProxyFactory cglibProxy = new ProxyFactory();
		Hello proxy = (Hello) cglibProxy.createProxy(hello);
		String result=proxy.sayHello(true);
		System.out.println(result);
	}
}

