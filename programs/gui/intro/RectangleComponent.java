import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.TwoDGraphicsComponent;
import util.TwoDUtil;

public class RectangleComponent extends TwoDGraphicsComponent {
	
	@Override
	protected void draw(Graphics2D graphics) {
		graphics.setColor(Color.BLUE);
		{
			final Rectangle rectangle = new Rectangle(20, 20, 15, 30);
			TwoDUtil.drawAndFill(graphics, rectangle);
			for(int i=0; i<80; i++) {
				rectangle.translate(5, 5);
				TwoDUtil.drawAndFill(graphics, rectangle);
			}
		}
		{
			final Rectangle rectangle = new Rectangle(20, 20, 15, 470);
			TwoDUtil.drawAndFill(graphics, rectangle);
			for(int i=0; i<80; i++) {
				rectangle.translate(-5, -5);
				TwoDUtil.drawAndFill(graphics, rectangle);
			}
		}
	}

}
