import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PhoneService extends JFrame {
	
	private final JTextField minuteField;
	private final JRadioButton daytimeChoice;
	private final JRadioButton eveningChoice;
	private final JRadioButton offpeakChoice;
	
	public PhoneService() {
		minuteField = new JTextField();
		minuteField.setPreferredSize(new Dimension(30, 25));
		daytimeChoice = new JRadioButton("Daytime");
		daytimeChoice.setSelected(true);
		eveningChoice = new JRadioButton("Evening");
		offpeakChoice = new JRadioButton("Off Peak");
		
		setSize(690, 80);
		setTitle("Phone Service");
		setResizable(false);
		
		final FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		final JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(layout);
		selectionPanel.add(new JLabel("Select your call time"));
		selectionPanel.add(daytimeChoice);
		selectionPanel.add(eveningChoice);
		selectionPanel.add(offpeakChoice);
		selectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(selectionPanel);
		
		final JPanel calculatePanel = new JPanel();
		calculatePanel.setLayout(layout);
		calculatePanel.add(new JLabel("Enter the amount of minutes"));
		calculatePanel.add(minuteField);
		final JButton button = new JButton("Calculate");
		button.addActionListener(new ButtonListener());
		calculatePanel.add(button);
		calculatePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(calculatePanel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PhoneService();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double rate;
			if(daytimeChoice.isSelected()) rate = 0.07;
			else if(eveningChoice.isSelected()) rate = 0.12;
			else if(offpeakChoice.isSelected()) rate = 0.05;
			else {
				JOptionPane.showMessageDialog(null, "No time selected.");
				return;
			}
			
			final int minutes;
			try {
				minutes = Integer.parseInt(minuteField.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid minutes input.");
				return;
			}
			
			JOptionPane.showMessageDialog(null, "Your bill would be $" + 
					NumberFormat.getInstance().format(minutes * rate) + ".");
		}
	}

}
