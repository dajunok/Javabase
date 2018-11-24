package liu.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 *方法拦截器
 */
public class HelloMethodInterceptor implements MethodInterceptor{

	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Before: "+method.getName());
		Object object=methodProxy.invokeSuper(o, objects);
		System.out.println("After:"+method.getName());
		return object;
	}

}
