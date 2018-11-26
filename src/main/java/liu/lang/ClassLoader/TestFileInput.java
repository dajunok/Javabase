package liu.lang.ClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFileInput {

	public static void main(String[] args) throws FileNotFoundException {		
		String mLibPaht="D:\\ETong\\java\\lib";  
		String  fileName="CustomLoader.class";  //ClassLoader.class
        File file = new File(mLibPaht,fileName);
        System.out.println(file.toString());
        
        FileInputStream is = new FileInputStream(file);

	}

}
