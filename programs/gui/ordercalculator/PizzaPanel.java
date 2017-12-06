import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class PizzaPanel extends JPanel {
	
	private final JRadioButton whitePizza;
	private final JRadioButton cheesePizza;
	private final JRadioButton noSaucePizza;
	
	public PizzaPanel() {
		whitePizza = new JRadioButton("White");
		cheesePizza = new JRadioButton("Cheese");
		cheesePizza.setSelected(true);
		noSaucePizza = new JRadioButton("No Sauce");
		
		final ButtonGroup group = new ButtonGroup();
		group.add(whitePizza);
		group.add(cheesePizza);
		group.add(noSaucePizza);
		
		add(cheesePizza);
		add(whitePizza);
		add(noSaucePizza);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Pizza Types"));
		setLayout(new GridLayout(4, 1));
	}
	
	public double getPizzaTotal() { 
		if(whitePizza.isSelected()) return 4.50;
		else if(cheesePizza.isSelected()) return 4.25;
		else if(noSaucePizza.isSelected()) return 4.35;
		else throw new RuntimeException("No pizza type selection made.");
	}

}
