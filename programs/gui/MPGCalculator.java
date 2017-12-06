import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MPGCalculator extends JFrame {
	
	private final JLabel gallonsLabel;
	private final JLabel milesDrivenLabel;
	private final JTextField gallonsInput;
	private final JTextField milesDrivenInput;
	private final JButton button;
	
	public MPGCalculator() {
		gallonsLabel = new JLabel("Enter number of gallons");
		milesDrivenLabel = new JLabel("Enter the maximum amount of miles");
		gallonsInput = new JTextField();
		gallonsInput.setPreferredSize(new Dimension(30, 20));
		milesDrivenInput = new JTextField();
		milesDrivenInput.setPreferredSize(new Dimension(30, 20));
		button = new JButton("Calculate");
		button.addActionListener(new ButtonListener());
		
		add(gallonsLabel);
		add(gallonsInput);
		add(milesDrivenLabel);
		add(milesDrivenInput);
		add(button);
		
		setLayout(new FlowLayout());
		setSize(500, 100);
		setTitle("MPG Calculator");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MPGCalculator();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource().equals(button)) {
				try {
					final int gallons = Integer.parseInt(gallonsInput.getText());
					final int miles = Integer.parseInt(milesDrivenInput.getText());
					JOptionPane.showMessageDialog(null, "The car has " + miles/gallons + "/mpg");
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Invalid input. Both fields must be numbers.");
				}
			}
		}
		
	}

}
