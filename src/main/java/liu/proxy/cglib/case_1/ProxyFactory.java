package liu.proxy.cglib.case_1;

import java.lang.reflect.Method;
 
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
 
public class ProxyFactory implements MethodInterceptor {
	 //要代理的原始对象
    private Object obj;
	public Object createProxy(Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.obj.getClass());// 设置代理目标
		enhancer.setCallback(this);// 设置回调
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}
 
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;
		try {
			// 前置通知
			before();
			result = proxy.invokeSuper(obj, args);
			// 后置通知
			after();
		} catch (Exception e) {
			exception();
		}finally{
			beforeReturning();
		}
		return result;
	}
 
 
	private void before() {
		System.out.println("before method invoke");
	}
	private void after() {
		System.out.println("after method invoke");
	}
	private void exception() {
		System.out.println("method invoke exception");
	}
	private void beforeReturning() {
		System.out.println("before returning");
	}
}

