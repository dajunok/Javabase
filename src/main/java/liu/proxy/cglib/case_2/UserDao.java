package liu.proxy.cglib.case_2;

/**cglib动态代理
 * 原始类对象（即代理目标对象）
 */
public class UserDao {
	public void save() {
		System.out.println("-----原始类对象方法save()被调用------");
	}
}


