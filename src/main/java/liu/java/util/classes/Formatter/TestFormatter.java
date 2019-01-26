package liu.java.util.classes.Formatter;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class TestFormatter {
	public static void main(String[] args) {  
        StringBuilder sb = new StringBuilder();  
        // Send all output to the Appendable object sb(将所有的 输出 发送到附加对象 sb )  
        /** Formatter(Appendable a, Locale l)  
            	构造一个带指定目标文件和语言环境的新 formatter。*/  
        Formatter formatter = new Formatter(sb, Locale.US);  
  
        // Explicit(详述的，明确的) argument indices(index的复数形式) may be used to re-order output.  
        /** 
         	* 明确的 “参数索引”(eg. agurment_index$) 可以用来对  输出文本(参数列表)  进行排序 
         */  
        formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");  
        // -> " d  c  b  a"  
  
 
        /** 
         	* 可选的local参数作为第一个参数 可以去 获取(或设定) 区域设置特定的数字格式 
         	* 精度和宽度的设定 可以 全面对其所要输出的格式 
         */  
        formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);  
        System.out.println(sb.toString());  
          
        // Writes a formatted string to System.out.  
           System.out.format("Local time: %tT", Calendar.getInstance());  
           // -> "Local time: 13:34:18"  
  
    }  

}
