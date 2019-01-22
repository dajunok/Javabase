package liu.java.util.ResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("liu/java/util/ResourceBundle/my", new Locale("zh", "CN"));
        String cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("liu/java/util/ResourceBundle/my", Locale.US);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("liu/java/util/ResourceBundle/my", Locale.getDefault());
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("liu/java/util/ResourceBundle/my", Locale.GERMAN);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);
        bundle = ResourceBundle.getBundle("liu/java/util/ResourceBundle/my");
        for (String key : bundle.keySet()) {
            System.out.println(bundle.getString(key));
        }
        
        /**输出结果：
         * 	取消
			cancel
			取消
			取消
			取消
         * 
         */
	}

}
