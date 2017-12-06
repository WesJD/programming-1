import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PizzaHut extends JFrame {
	
	private final JCheckBox italianSausage;
	private final JCheckBox bacon;
	private final JCheckBox greenPeppers;
	
	private final JRadioButton small;
	private final JRadioButton medium;
	private final JRadioButton large;
	
	private PizzaHut() {
		italianSausage = new JCheckBox("Italian Sausage");
		bacon = new JCheckBox("Bacon");
		greenPeppers = new JCheckBox("Green Peppers");
		
		small = new JRadioButton("Small");
		medium = new JRadioButton("Medium");
		medium.setSelected(true);
		large = new JRadioButton("Large");
		//register them together
		final ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);
		
		final FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setTitle("Pizza Hut Order");
		setSize(750, 100);
		setResizable(false);
		
		final JPanel toppingsPanel = new JPanel();
		toppingsPanel.setLayout(layout);
		toppingsPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Extra Toppings"));
		toppingsPanel.add(italianSausage);
		toppingsPanel.add(bacon);
		toppingsPanel.add(greenPeppers);
		add(toppingsPanel);
		
		final JPanel sizePanel = new JPanel();
		sizePanel.setLayout(layout);
		sizePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Size"));
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		add(sizePanel);
		
		add(Box.createRigidArea(new Dimension(20, 0)));
		
		final JButton button = new JButton("Calculate Total");
		button.setPreferredSize(new Dimension(120, 40));
		button.addActionListener(new ButtonListener());
		add(button);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PizzaHut();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double toppingsTotal = 0;
			if(italianSausage.isSelected()) toppingsTotal += 1;
			if(bacon.isSelected()) toppingsTotal += 1;
			if(greenPeppers.isSelected()) toppingsTotal += 1;
			
			final double sizeCost;
			if(small.isSelected()) sizeCost = 8.99;
			else if(medium.isSelected()) sizeCost = 9.99;
			else if(large.isSelected()) sizeCost = 10.99;
			else throw new RuntimeException("wat");
			
			JOptionPane.showMessageDialog(null, "Your order will cost " + NumberFormat.getInstance().format(toppingsTotal + sizeCost));
		}
	}

}
