import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OrderCalculator extends JFrame {
	
	private final PizzaPanel pizzaPanel;
	private final DrinkPanel drinkPanel;
	private final ToppingsPanel toppingsPanel;
	private final SidesPanel sidesPanel;
	private final WingsPanel wingsPanel;
	
	private OrderCalculator() {
		pizzaPanel = new PizzaPanel();
		drinkPanel = new DrinkPanel();
		toppingsPanel = new ToppingsPanel();
		sidesPanel = new SidesPanel();
		wingsPanel = new WingsPanel();
		
		setTitle("Pizza Hut Calculator");
		setResizable(false);
		setLayout(new BorderLayout());
		
		add(new JLabel("Select your order:"), BorderLayout.NORTH);
	    add(pizzaPanel, BorderLayout.WEST);
	    
	    final JPanel centerPanel = new JPanel();
	    centerPanel.setLayout(new BorderLayout());
	    centerPanel.add(toppingsPanel, BorderLayout.WEST);
	    centerPanel.add(sidesPanel, BorderLayout.CENTER);
	    centerPanel.add(wingsPanel, BorderLayout.EAST);
	    add(centerPanel, BorderLayout.CENTER);
	    
	    add(drinkPanel, BorderLayout.EAST);
		
		final JButton button = new JButton("Calculate");
		button.addActionListener(new ButtonListener());
		add(button, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new OrderCalculator();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double total = 0;
			total += pizzaPanel.getPizzaTotal();
			total += drinkPanel.getDrinkTotal();
			total += toppingsPanel.getToppingsTotal();
			total += sidesPanel.getSidesTotal();
			total += wingsPanel.getWingsTotal();
			JOptionPane.showMessageDialog(null, "Your order will be a total of $" + total);
		}
	}

}
