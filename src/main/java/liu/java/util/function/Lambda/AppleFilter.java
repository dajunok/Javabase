package liu.java.util.function.Lambda;

/**
 * 将筛选条件封装成接口
 *
 * @param apples
 * @param filter
 * @return
 */
public interface AppleFilter {
	boolean accept(Apple apple);
}
