package util;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public abstract class TwoDGraphicsComponent extends JComponent {
	
	protected abstract void draw(Graphics2D graphics);
	
	@Override
	protected void paintComponent(Graphics arg0) {
		draw((Graphics2D) arg0);
	}

}
