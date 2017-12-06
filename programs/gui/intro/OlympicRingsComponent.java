import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import util.TwoDGraphicsComponent;

public class OlympicRingsComponent extends TwoDGraphicsComponent {

	@Override
	protected void draw(Graphics2D graphics) {
		graphics.setStroke(new BasicStroke(5));
		
		//center black ring
		graphics.draw(new Ellipse2D.Double(190, 150, 75, 75));
		
		//yellow ring
		graphics.setColor(Color.YELLOW);
		graphics.draw(new Ellipse2D.Double(145, 180, 75, 75));
		
		//blue ring
		graphics.setColor(Color.BLUE);
		graphics.draw(new Ellipse2D.Double(95, 150, 75, 75));
		
		//green ring
		graphics.setColor(Color.GREEN);
		graphics.draw(new Ellipse2D.Double(235, 180, 75, 75));
		
		//red ring
		graphics.setColor(Color.RED);
		graphics.draw(new Ellipse2D.Double(285, 150, 75, 75));	
	}

}
