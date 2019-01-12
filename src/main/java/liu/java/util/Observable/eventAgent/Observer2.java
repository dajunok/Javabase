package liu.java.util.Observable.eventAgent;

import java.util.Date;

/**
 *	 观察者2：相当于一个事件监听器
 * @author LIU
 *
 */
public class Observer2 {
    public Observer2(){
        System.out.println("Obsever2状态1");
    }
    
    public void changeState2(Date date){
        System.out.println("Observer2改变状态" + date);
    }
}
