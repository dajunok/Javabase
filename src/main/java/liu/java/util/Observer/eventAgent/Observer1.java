package liu.java.util.Observer.eventAgent;

import java.util.Date;

/**
 * 	观察者1：相当于一个事件监听器
 * @author LIU
 *
 */
public class Observer1 {
    public Observer1(){
        System.out.println("Observer1状态1");
    }
    
    public void changeState1(Date date){
        System.out.println("Observer1改变状态" + date);
    }
}
