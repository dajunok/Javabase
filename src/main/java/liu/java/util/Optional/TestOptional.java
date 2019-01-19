package liu.java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class TestOptional {	
	
	//创建 Optional实例。毫不奇怪，尝试访问 emptyOpt 变量的值会导致 NoSuchElementException。
	@Test(expected =NoSuchElementException.class)
	public void whenCreateEmptyOptional_thenNull() {
	    Optional<User> emptyOpt = Optional.empty();
	    emptyOpt.get();
	}
	
	//你可以使用  of() 和 ofNullable() 方法创建包含值的 Optional。两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException：
	@Test(expected = NullPointerException.class)
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user=null;
	    Optional<User> opt = Optional.of(user);
	}
	
	//如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法：
	@Test(expected = NullPointerException.class)
	public void whenCreateOfEmptyOptional_thenNullable() {
		User user=null;
	    Optional<User> opt = Optional.ofNullable(user); //不会产生NullPointerException异常
	}
	
	
	//从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法。这个方法会在值为 null 的时候抛出异常。
	@Test
	public void whenCreateOfNullableOptional_thenOk() {
	    String name = "John";
	    Optional<String> opt = Optional.ofNullable(name);

	    assertEquals("John", opt.get());
	}
	
	////要避免异常，你可以选择首先验证是否有值：
	@Test
	public void whenCheckIfPresent_thenOk() {
	    User user = new User("john@gmail.com", "1234");
	    //user=null;
	    Optional<User> opt = Optional.ofNullable(user);
	    assertTrue(opt.isPresent()); //如果为true，则运行success，反之Failure ,运行失败后的错误提示

	    assertEquals(user.getUserName(), opt.get().getUserName());  //如果预期值与真实值相等，则运行success，反之Failure，反之Failure ,运行失败后的错误提示
	}
	
	//检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式：
	@Test
	public void whenCheckIfPresent_CallConsumer() {
	    User user = new User("john@gmail.com", "1234");
	    //user=null;
	    Optional<User> opt = Optional.ofNullable(user);
	    
	    assertTrue(opt.isPresent()); //如果为true，则运行success，反之Failure ,运行失败后的错误提示
	    opt.ifPresent( u -> assertEquals(user.getUserName(), u.getUserName()));

	   }
	
	
	//从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法。
	@Test
	public void whenCreateEmptyOptional_thenNonNull() {
	    Optional<String> emptyOpt = Optional.of("zhangSan");
	    String s=emptyOpt.get();
	    System.out.println(s);
	}
	
	
	/****返回默认值
	 * Optional 类提供了 API 用以返回对象值，或者在对象为空的时候返回默认值。
	 * 
	 * 
	 * */
	//这里你可以使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值：
	@Test
	public void whenEmptyValue_thenReturnDefault() {
	    User user = null;
	    User user2 = new User("anna@gmail.com", "1234");
	    User result = Optional.ofNullable(user).orElse(user2);  //这里 user 对象是空的，所以返回了作为默认值的 user2。

	    assertEquals(user2.getUserName(), result.getUserName());
	}
	
	//如果对象的初始值不是 null，那么默认值会被忽略：
	@Test
	public void whenValueNotNull_thenIgnoreDefault() {
	    User user = new User("john@gmail.com","1234");
	    User user2 = new User("anna@gmail.com", "1234");
	    User result = Optional.ofNullable(user).orElse(user2);
	    
	    //第二个同类型的 API 是 orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果：
	    //User result = Optional.ofNullable(user).orElseGet( () -> user2);

	    assertEquals("john@gmail.com", result.getUserName());
	}
	
	/**
	 * orElse() 和 orElseGet() 的不同之处
	 * 	在执行较密集的调用时，比如调用 Web 服务或数据查询，这个差异会对性能产生重大影响。
	 */
	
	//我们先来看看对象为空时他们的行为：
	@Test
	public void givenEmptyValue_whenCompare_thenOk() {
	    User user = null;
	    System.out.println("1----------------------------------------");
	    System.out.println("Using orElse");
	    User result = Optional.ofNullable(user).orElse(createNewUser());
	    System.out.println("Using orElseGet");
	    User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	    /*输出结果：
		    Using orElse
			Creating New User
			Using orElseGet
			Creating New User
	     */
	    //由此可见，当对象为空而返回默认对象时，行为并无差异。
	}
	
	//我们接下来看一个类似的示例，但这里 Optional  不为空：
	@Test
	public void givenPresentValue_whenCompare_thenOk() {
	    User user = new User("john@gmail.com", "1234");
	    System.out.println("2----------------------------------------");
	    System.out.println("Using orElse");
	    User result = Optional.ofNullable(user).orElse(createNewUser());
	    System.out.println("Using orElseGet");
	    User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	    
	    /*输出结果：
		    Using orElse
			Creating New User
			Using orElseGet
	     */
	    //这个示例中，两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse() 方法仍然创建了 User 对象。与之相反，orElseGet() 方法不创建 User 对象。
	}

	private User createNewUser() {
		System.out.println("Creating New User");
	    return new User("extra@gmail.com", "1234");
	}
	
	//
	

}

class User{
	private String userName;
	private String password;
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	
}






















