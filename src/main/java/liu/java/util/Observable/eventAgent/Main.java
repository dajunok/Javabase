package liu.java.util.Observable.eventAgent;

import java.util.Date;

/**
 * 	利用事件委托弥补观察者模式不足
 * @author LIU
 *
 */
public class Main {

	public static void main(String[] args) {
		Notifier notifier = new ConcreteNotifier();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        
        notifier.attach(observer1, "changeState1", new Date());
        notifier.attach(observer2, "changeState2", new Date());
        
        notifier.notifyObj();
	}

}
