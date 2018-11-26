package liu.proxy.cglib.case_2;

public class App {
	public static void main(String[] args) {
		//原始类对象
        UserDao target = new UserDao();

        //代理类对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //调用代理对象方法
        proxy.save();

	}
}
