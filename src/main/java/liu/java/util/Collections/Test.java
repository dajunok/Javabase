package liu.java.util.Collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// create set
	      Set<String> set = new HashSet<String>();
	      
	      // populate the set
	      set.add("Welcome");
	      set.add("to");
	      set.add("TP");
	      
	      System.out.println("Initial set value: "+set);
	      
	      // create unmodifiable set
	      Set<String> unmodset = Collections.unmodifiableSet(set);

	      //Exception in thread "main" java.lang.UnsupportedOperationException
	      unmodset.add("Hello");
	}

}
