package liu.java.util.Observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 	实现java.util.Observer接口的观察者（相当与事件监听器）
 * @author LIU
 *	
 * Subscribe：订阅者（观察者）
 */

public class Subscribe implements Observer{
	
	public Subscribe(Observable o) {
		o.addObserver(this);   //将该观察者放入待通知者里
	}

	@Override
	public void update(Observable o, Object arg) {
		 System.out.println("收到通知:" + ((Publish)o).getData());
		
	}

}
