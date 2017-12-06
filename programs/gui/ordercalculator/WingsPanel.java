import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class WingsPanel extends JPanel {
	
	private final JCheckBox traditional;
	private final JCheckBox breaded;
	
	public WingsPanel() {
		traditional = new JCheckBox("Traditional");
		breaded = new JCheckBox("Breaded");
		
		add(traditional);
		add(breaded);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Wings"));
		setLayout(new GridLayout(4, 1));
	}
	
	public double getWingsTotal() {
		double wingsTotal = 0;
		if(traditional.isSelected()) wingsTotal += 3.50;
		if(breaded.isSelected()) wingsTotal += 4.25;
		return wingsTotal;
	}

}
