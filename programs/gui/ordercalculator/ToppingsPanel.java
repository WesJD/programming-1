import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class ToppingsPanel extends JPanel {
	
	private final JCheckBox pineapple;
	private final JCheckBox pepperoni;
	private final JCheckBox sausage;
	private final JCheckBox bacon;
	
	public ToppingsPanel() {
		pineapple = new JCheckBox("Pineapple");
		pepperoni = new JCheckBox("Pepperoni");
		sausage = new JCheckBox("Sausage");
		bacon = new JCheckBox("Bacon");
		
		add(pineapple);
		add(pepperoni);
		add(sausage);
		add(bacon);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Toppings"));
		setLayout(new GridLayout(4, 1));
	}
	
	public double getToppingsTotal() {
		double toppingsTotal = 0;
		if(pineapple.isSelected()) toppingsTotal += 0.50;
		if(pepperoni.isSelected()) toppingsTotal += 0.25;
		if(sausage.isSelected()) toppingsTotal += 0.75;
		if(bacon.isSelected()) toppingsTotal += 0.75;
		return toppingsTotal;
	}

}
