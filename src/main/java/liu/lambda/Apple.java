package liu.lambda;

import com.sun.prism.paint.Color;

@SuppressWarnings("restriction")
public class Apple {
	/** 编号 */
    @SuppressWarnings("unused")
	private long id;

    /** 颜色*/
    private Color color;

    /** 重量 */
    private float weight;

    /** 产地 */
    @SuppressWarnings("unused")
	private String origin;

    public Apple() {
    }
    
    public Color getColor() {
    	return this.color;
    }
    
    public float getWeight() {
		return this.weight;
	}
    
    public Apple(long id, Color color, float weight, String origin) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }
}
