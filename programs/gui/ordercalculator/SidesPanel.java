import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class SidesPanel extends JPanel {
	
	private final JCheckBox breadsticks;
	private final JCheckBox cinnamonsticks;
	private final JCheckBox lavacake;
	
	public SidesPanel() {
		breadsticks = new JCheckBox("Bread Sticks");
		cinnamonsticks = new JCheckBox("Cinnamon Sticks");
		lavacake = new JCheckBox("Lava Cake");
		
		add(breadsticks);
		add(cinnamonsticks);
		add(lavacake);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Sides / Dessert"));
		setLayout(new GridLayout(4, 1));
	}
	
	public double getSidesTotal() { 
		double sidesTotal = 0;
		if(breadsticks.isSelected()) sidesTotal += 1.25;
		if(cinnamonsticks.isSelected()) sidesTotal += 1.45;
		if(lavacake.isSelected()) sidesTotal += 2.00;
		return sidesTotal;
	}

}
