package liu.lang.Class;

/*断言
 * desiredAssertionStatus():boolean   判断该类的断言功能是否已打开。 
 * 
 */

class TestAssert {
    public void test(){
        System.out.println("TestAssert -> 断言是否已打开=" + TestAssert.class.desiredAssertionStatus());
        assert false : "断言信息!";
    }
}

public class AboutAssertionStatus {
	
	public static void main(String[] args) {
		System.out.println(TestAssert.class.getName());
		AboutAssertionStatus.class.getClassLoader().setClassAssertionStatus(TestAssert.class.getName(), true); //true：启动断言；false：关闭断言
		TestAssert testAssert=new TestAssert();
		testAssert.test();
	}

}
