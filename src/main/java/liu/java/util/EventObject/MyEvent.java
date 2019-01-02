package liu.java.util.EventObject;

import java.util.EventObject;

/**
 * 	事件对象：它封装了Source类（事件源），就是平常所说的“事件”，一般作为事件监听器处理方法的入参。
 * @author LIU
 *
 */
public class MyEvent extends EventObject{
	private static final long serialVersionUID = 1L;
    private int sourceState;
    
    public MyEvent(Object source) {   //source：事件源
        super(source); //调用父类的构造方法
        sourceState = ((Source)source).getFlag();
    }
    
    public int getSourceState() {
        return sourceState;
    }
}
