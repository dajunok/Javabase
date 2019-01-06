package liu.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**jdk动态代理：
 * 实现在方法调用前后向控制台输出两句字符串
 * @author LIU
 *
 */
public class HelloWorldHandler implements InvocationHandler {
	//要代理的原始对象
	private Object obj;
	
	public  HelloWorldHandler(Object obj) {//构造时传入原始对象
		super();
		this.obj=obj;
	}

	/**在代理实例上处理方法调用并返回结果
	 * 
	 * @param proxy   代理类
	 * @param method  被代理的方法
	 * @param args    该方法的参数数组
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		//调用前
		doBefore();
		//调用原始对象方法
		result=method.invoke(obj, args);
		//掉用之后
		doAfter();
		return result;
	}
	
	private void doBefore() {
		System.out.println("before method invoke");
	}
	
	private void doAfter() {
		System.out.println("after method invoke");
	}

}
