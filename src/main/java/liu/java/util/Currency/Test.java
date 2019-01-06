package liu.java.util.Currency;

import java.util.Currency;
import java.util.Locale;

/**
 * Currency类：货币
 * @author dajun
 *
 */
public class Test {

	public static void main(String[] args) {
		
		//美国货币符号
		Currency currency = Currency.getInstance(Locale.US); 
		System.out.println("United States: " + currency.getSymbol());
		
		//联合国货币符号
		currency = Currency.getInstance(Locale.UK);
		System.out.println("United Kingdom: " + currency.getSymbol());
		
		//法国货币符号
		currency = Currency.getInstance(Locale.FRANCE);
		System.out.println("France: " + currency.getSymbol());
		System.out.println("货币代码: " + currency.getCurrencyCode());
		System.out.println("法国货币DisplayLocale名称: " + currency.getDisplayName());
		currency = Currency.getInstance(Locale.CHINA);
		System.out.println("中国货币DisplayLocale名称: " + currency.getDisplayName(Locale.CHINESE));

	}

}
