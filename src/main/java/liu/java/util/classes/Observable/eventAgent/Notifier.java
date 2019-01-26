package liu.java.util.classes.Observable.eventAgent;

/**
 * 	抽象通知者
 * @author LIU
 *
 */
public abstract class Notifier {
	private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void attach(Object object, String methodName, Object...args);
    
    public abstract void notifyObj();
}