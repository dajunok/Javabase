package liu.lang.Exception;

/**
 * 自定义异常类
 * @author LIU
 *
 */
public class OrderException extends Exception {
	private static final long serialVersionUID = -1509272605891135841L;
	
	public OrderException() {
        super();
    }
	
	 public OrderException(String message) {
	        super(message);
	    }
	
	 public OrderException(String message, Throwable cause) {
	        super(message, cause);
	    }
	 
	 public OrderException(Throwable cause) {
	        super(cause);
	    }
	
	 protected OrderException(String message, Throwable cause,
             boolean enableSuppression,
             boolean writableStackTrace) {
		 super(message, cause, enableSuppression, writableStackTrace);
	 }
}
