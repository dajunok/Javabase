package liu.lang.Class;


/* isSynthetic():boolean 判断该类是否由编译器编译成class文件时所增加的(是否合成类)，否则它是由编程人员编写java源文件时所编写的。
 * 
 */
public class About_isSynthetic {
   
	public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("liu.lang.Class.About_isSynthetic").isSynthetic());
	}

}

