package liu.java.util.classes.Observable.eventAgent;

/**
 *	 具体通知者
 * @author LIU
 *
 */
public class ConcreteNotifier extends Notifier {

    @Override
    public void attach(Object object, String methodName, Object... args) {
        this.getEventHandler().addEvent(object, methodName, args);
    }


    @Override
    public void notifyObj() {
        try {
            this.getEventHandler().notifyObj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
