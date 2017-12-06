import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class DrinkPanel extends JPanel {
	
	private final JCheckBox soda;
	private final JCheckBox water;
	private final JCheckBox tea;
	
	public DrinkPanel() {
		soda = new JCheckBox("Soda");
		water = new JCheckBox("Water");
		tea = new JCheckBox("Tea");
		
		add(soda);
		add(water);
		add(tea);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Drinks"));
		setLayout(new GridLayout(4, 1));
	}
	
	public double getDrinkTotal() { 
		double drinkTotal = 0;
		if(soda.isSelected()) drinkTotal += 1.25;
		if(water.isSelected()) drinkTotal += 1.25;
		if(tea.isSelected()) drinkTotal += 2.00;
		return drinkTotal;
	}

}
