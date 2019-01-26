package liu.java.util.classes.Observable.eventAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * 	管理事件类
 * @author LIU
 *
 */
public class EventHandler {
	private List<Event> objects;
    
    public EventHandler(){
        objects = new ArrayList<Event>();
    }
    
    public void addEvent(Object object, String methodName, Object...args){
        objects.add(new Event(object, methodName, args));
    }
    
    public void notifyObj() throws Exception{
        for (Event event : objects){
            event.invoke();
        }
    }
}
