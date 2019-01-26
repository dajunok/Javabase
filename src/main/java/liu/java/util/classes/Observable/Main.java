package liu.java.util.classes.Observable;

/**
 * Publish:通知者，父类是Observable。
 * Subscribe：观察者（相当于监听器），实现了Observer接口。
 *
 */
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Publish publish = new Publish();
		Subscribe subscribe = new Subscribe(publish);
		publish.setData("开始");
	}

}
