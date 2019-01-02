package liu.java.util.Observer.eventAgent;

import java.lang.reflect.Method;

/**
 * 	事件类
 * @author LIU
 *
 */
public class Event {
	private Object object;
    private String methodName;
    private Object[] params;
	private Class[]    paramsType;
    
    public Event(Object object, String methodName, Object...args){
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        contractParamTypes(this.params);
    }


    private void contractParamTypes(Object[] params2) {
        this.paramsType = new Class[params2.length];
        for (int i = 0; i < params.length; i++){
            this.paramsType[i] = params[i].getClass();
        }
    }
    
    public void invoke() throws Exception{
        Method method = object.getClass().getMethod(this.methodName, this.paramsType);
        if (null == method){
            return ;
        }
        method.invoke(this.object, this.params);
    }
}