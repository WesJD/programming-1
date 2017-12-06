package util;

import java.awt.Graphics2D;
import java.awt.Shape;

public class TwoDUtil {
	
	public static void drawAndFill(Graphics2D graphics, Shape shape) {
		graphics.draw(shape);
		graphics.fill(shape);
	}

}
