import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import util.TwoDGraphicsComponent;

public class FaceComponent extends TwoDGraphicsComponent {

	@Override
	protected void draw(Graphics2D graphics) {
		graphics.draw(new Ellipse2D.Double(50, 50, 100, 100)); //circle
		graphics.draw(new Ellipse2D.Double(65, 75, 15, 15)); //eye 1
		graphics.draw(new Ellipse2D.Double(115, 75, 15, 15)); //eye 2
		graphics.draw(new Line2D.Double(70, 125, 125, 125)); //flat mouth
	}

}
