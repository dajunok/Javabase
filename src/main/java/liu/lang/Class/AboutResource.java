package liu.lang.Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*路径资源
 * getResource(String):URL	获取与该类所在目录下的路径资源。
 * getResourceAsStream(String):InputStream	path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源
 */
public class AboutResource {

	public static class Parent{}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//获取与该类所在目录下的路径资源。
		System.out.println("(1)===========================================");
		System.out.println(Parent.class.getResource(""));    // 获取当前类(class)所在的包目录
		System.out.println(Parent.class.getResource("AboutResource.java"));  //不能获取源文件路径，所以在这里显示null。
		System.out.println(Parent.class.getResource("AboutResource.class"));
		System.out.println(Parent.class.getResource("/"));   // 获取class path根目录
		
		//获取与该类所在目录下的路径资源。
		System.out.println("(2)===========================================");
		InputStream inputStream=Class.forName("liu.lang.Class.AboutResource$Parent").getResourceAsStream("resource.txt");
		InputStreamReader reader=new InputStreamReader(inputStream);//通过输入流阅读器获取输入流
		BufferedReader br=new BufferedReader(reader); //通过缓存阅读器读入缓存
		System.out.println(br.readLine());            //通过缓存阅读器方法readLine()显示文件内容。
	}

}
