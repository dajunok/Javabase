package liu.lang.ClassLoader;

public class Test {

	public static void main(String[] args) {
		System.out.println(System.nanoTime()); //生成随机数
		System.out.println(System.nanoTime()); //生成随机数
		long t0=System.nanoTime();
		long t1=System.nanoTime();
		
/*		sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
        sun.misc.PerfCounter.getFindClasses().increment();*/
        //
        Test.class.getClassLoader().getSystemClassLoader();
	}

}
