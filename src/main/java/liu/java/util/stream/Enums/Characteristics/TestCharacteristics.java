package liu.java.util.stream.Enums.Characteristics;

import java.util.stream.Collector;

public class TestCharacteristics {
	public static void main(String[] args) {
		for (Collector.Characteristics c : Collector.Characteristics.values())
		    System.out.println(c);	
	}

}
