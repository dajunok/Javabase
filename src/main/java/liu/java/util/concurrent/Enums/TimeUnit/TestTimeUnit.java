package liu.java.util.concurrent.Enums.TimeUnit;

import java.util.concurrent.TimeUnit;

public class TestTimeUnit {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Sleeping for 4 minutes using Thread.sleep()");
		Thread.sleep(4 * 60 * 1000);
        System.out.println("Sleeping for 4 minutes using TimeUnit sleep()");
 
        TimeUnit.SECONDS.sleep(4);
        TimeUnit.MINUTES.sleep(2);
        TimeUnit.HOURS.sleep(1);
        TimeUnit.DAYS.sleep(1);
        
        long a=TimeUnit.SECONDS.toMillis(44);
        System.out.println(a);
		
	}
	

}
