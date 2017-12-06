import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import util.TwoDGraphicsComponent;

public class NameComponent extends TwoDGraphicsComponent {

	@Override
	protected void draw(Graphics2D graphics) {
		graphics.draw(new Rectangle2D.Double(20, 20, 100, 20));
		graphics.drawString("Wesley S.", 40, 35);
	}

}
