import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class CarComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		final Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.CYAN);
		
		//body
		final Point bodyStart = new Point(200, 200);
		final Rectangle body = new Rectangle(bodyStart, new Dimension(350, 60));
		graphics.draw(body);
		graphics.fill(body);
		
		///glass
		final Point glassStart = new Point(bodyStart);
		glassStart.translate(50, 0);
		
		final Point glassTopStart = new Point(glassStart);
		glassTopStart.translate(25, -65);
		
		graphics.draw(new Line2D.Double(glassStart, glassTopStart));
		
		final Point glassTopEnd = new Point(glassTopStart);
		glassTopEnd.translate(200, 0);
		
		graphics.draw(new Line2D.Double(glassTopStart, glassTopEnd));
		
		final Point glassEnd = new Point(glassTopEnd);
		glassEnd.translate(25, 65);
		
		graphics.draw(new Line2D.Double(glassTopEnd, glassEnd));
		
		//wheels
		final int wheeelDiameter = 60;
		final Point firstWheel = new Point(bodyStart);
		firstWheel.translate(50, 60);
		
		{
			final Ellipse2D wheel = fromPoint(firstWheel, new Dimension(wheeelDiameter, wheeelDiameter));
			graphics.draw(wheel);
			graphics.fill(wheel);
		}
		
		final Point secondWheel = new Point(firstWheel);
		secondWheel.translate(200, 0);
		
		{
			final Ellipse2D wheel = fromPoint(secondWheel, new Dimension(wheeelDiameter, wheeelDiameter));
			graphics.draw(wheel);
			graphics.fill(wheel);
		}
	}
	
	private Ellipse2D fromPoint(Point point, Dimension dimension) {
		return new Ellipse2D.Double(point.getX(), point.getY(), dimension.getHeight(), dimension.getWidth());
	}
	
}
