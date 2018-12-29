package liu.java.util;

import java.util.Iterator;

public class Test {
	Iterable<Integer> iterable=new Iterable<Integer>() {
		
		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	
	public static void main(String[] args) {
		Iterable<Integer> iterable2=()->null;
	}
}
