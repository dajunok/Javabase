package liu.java.util.classes.EventObject;

public class Test {

	public static void main(String[] args) {
		Source source = new Source();
        source.addStateChangeListener(new StateChangeListener());
        source.addStateChangeToOneListener(new StateChangeToOneListener());
        
        source.changeFlag();  //改变标识触发事件
        System.out.println("//------------------------------------------");
        
        source.changeFlag();  //改变标识触发事件
        System.out.println("//------------------------------------------");
        
        
        source.changeFlag();   //改变标识触发事件

	}

}
