import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import util.TwoDGraphicsComponent;

public class HouseComponent extends TwoDGraphicsComponent {

	@Override
	protected void draw(Graphics2D graphics) {
		//TRIANGLE
		final Point2D left = new Point2D.Double(50, 50);
		final Point2D right = new Point2D.Double(150, 50);
		final Point2D upperMid = new Point2D.Double(100, 25);
		graphics.draw(new Line2D.Double(left, right));
		graphics.draw(new Line2D.Double(right, upperMid));
		graphics.draw(new Line2D.Double(left, upperMid));
		
		//BOTTOM SQUARE
		graphics.draw(new Rectangle2D.Double(left.getX(), left.getY(), 100, 70));
		
		//DOOR
		graphics.draw(new Rectangle2D.Double(left.getX()+43, left.getY()+50, 15, 20));
		
		//WINDOWS
		graphics.draw(new Rectangle2D.Double(left.getX()+15, left.getY()+12, 20, 20));
		graphics.draw(new Rectangle2D.Double(right.getX()-35, right.getY()+12, 20, 20)); //subtract 35 as it draws from the top left
	}

}
