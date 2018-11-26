package liu.proxy.cglib.case_2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**Cglib动态代理
 * 		运行时动态的生成一个被代理类的子类（通过ASM字节码处理框架实现），子类重写了被代理类中所有非final的方法。在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势植入横切逻辑。
 * 代理工厂实现方法拦截器接口MethodInterceptor
 */
public class ProxyFactory implements MethodInterceptor{
	//原始类对象
	private Object target;
	
	public ProxyFactory(Object target) {
		this.target=target;		
	}
	
	public Object getProxyInstance() {
		//创建Cglib字节码增强器
		Enhancer en=new Enhancer();
		//把原始类设置为代理类的父类
		en.setSuperclass(target.getClass());
		//设置回调（即实现实现方法拦截器接口MethodInterceptor的对象）
		en.setCallback(this);
		//创建代理类对象并返回它
		return en.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Cglib拦截前......");		
		//调用原始类方法
		Object returnValue=method.invoke(target, args);
		System.out.println("Cglib拦截后......");
		
		return returnValue;
	}

}
