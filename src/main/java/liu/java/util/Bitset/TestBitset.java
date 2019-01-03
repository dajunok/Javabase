package liu.java.util.Bitset;

import java.util.BitSet;

/**
 * 	测试位集运算（对位集进行二进制按位运算）
 * @author LIU
 *
 */
public class TestBitset {

	public static void main(String[] args) {
		BitSet bits1 = new BitSet(16);    //创建一个16位的位集
	     BitSet bits2 = new BitSet(16);
	      
	     /**
	      * set(int bitIndex):void 
				将指定索引处的位设置为 true。
	      */
	     for(int i=0; i<16; i++) {
	        if((i%2) == 0) bits1.set(i);
	        if((i%5) != 0) bits2.set(i);
	     }
	     System.out.println("Initial pattern in bits1: ");
	     System.out.println(bits1);
	     System.out.println("\nInitial pattern in bits2: ");
	     System.out.println(bits2);
	 
	     // AND bits（与运算）
	     bits2.and(bits1);
	     System.out.println("\nbits2 AND bits1: ");
	     System.out.println(bits2);
	 
	     // OR bits（或运算）
	     bits2.or(bits1);
	     System.out.println("\nbits2 OR bits1: ");
	     System.out.println(bits2);
	 
	     // XOR bits（异或运算）
	     bits2.xor(bits1);
	     System.out.println("\nbits2 XOR bits1: ");
	     System.out.println(bits2);
	}

}
