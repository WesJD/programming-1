import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CelciusToFarenheight extends JFrame {
	
	private final JTextField textField;
	private final JButton button;
	
	public CelciusToFarenheight() {
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(30, 20));
		button = new JButton("Convert to Farenheight");
		button.addActionListener(new ButtonListener());
		
		add(textField);
		add(button);
		
		setLayout(new FlowLayout());
		setSize(200, 100);
		setTitle("Temperature Converter");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CelciusToFarenheight();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource().equals(button)) {
				try {
					final int celcius = Integer.parseInt(textField.getText());
					JOptionPane.showMessageDialog(null, celcius + " Celcius is " + (9/5*celcius+32) + " Farenheight");
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Invalid input. Must be a number.");
				}
			}
		}
		
	}

}
