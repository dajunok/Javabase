package liu.java.io;

import java.nio.charset.Charset;

public class Test {
	enum Size {SMAll,MEDIUM,LARGE};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int con=1;
		float num=(float) 1.0;
		boolean done=false;
		
		byte[] b = new byte[]{'d','1','c'};		
		byte[] b1 = new byte[]{'d',(byte)0xff,-1,(byte)255,(byte)0x80,(byte) 128,-128};
		Charset charset = Charset.forName("UTF-8");
		String str=new String(b,charset);
		System.out.println(str);
		System.out.println(b1[4]);
		Size size=Size.SMAll;
		if(size==size.SMAll) {
			System.out.println("相等");
		}
		System.out.println(num);
		

	}

}
