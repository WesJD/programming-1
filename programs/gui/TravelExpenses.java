import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TravelExpenses extends JFrame {
	
	private final JTextField daysField;
	private final JTextField airfareField;
	private final JTextField milesDrivenField;
	private final JTextField taxiChargesField;
	private final JTextField registrationFeesField;
	private final JTextField lodgingChargesField;
	
	private TravelExpenses() {
		daysField = new JTextField(5);
		airfareField = new JTextField(5);
		milesDrivenField = new JTextField(5);
		taxiChargesField = new JTextField(5);
		registrationFeesField = new JTextField(5);
		lodgingChargesField = new JTextField(5);
		
		final FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setTitle("Travel Expenses");
		setSize(1050, 100);
		setResizable(false);
		
		final JPanel panel = new JPanel();
		panel.setLayout(layout);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Expenses"));
		panel.add(new JLabel("Days on trip"));
		panel.add(daysField);
		panel.add(new JLabel("Airfare costs"));
		panel.add(airfareField);
		panel.add(new JLabel("Miles driven"));
		panel.add(milesDrivenField);
		panel.add(new JLabel("Taxi charges"));
		panel.add(taxiChargesField);
		panel.add(new JLabel("Registration fees"));
		panel.add(registrationFeesField);
		panel.add(new JLabel("Lodging charges"));
		panel.add(lodgingChargesField);
		add(panel);
		
		add(Box.createRigidArea(new Dimension(15, 0)));
		
		final JButton button = new JButton("Calculate");
		button.setPreferredSize(new Dimension(90, 35));
		button.addActionListener(new ButtonListener());
		getRootPane().setDefaultButton(button);
		add(button);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TravelExpenses();
	}
	
	// 10 1000 50 50 100 10
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				double overallExpense = 0;
				double given = 0;
				if(!airfareField.getText().isEmpty()) overallExpense += Double.parseDouble(airfareField.getText());
				if(!registrationFeesField.getText().isEmpty()) overallExpense += Double.parseDouble(registrationFeesField.getText());
				
				if(daysField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must supply the amount of days.");
					return;
				}
				final int days = Integer.parseInt(daysField.getText());
				given += 37 * days;
				if(!milesDrivenField.getText().isEmpty()) {
					given += (0.27 * Integer.parseInt(milesDrivenField.getText())); //0.27 per mile
					given += 10 * days; //parking fees
				}
				if(!lodgingChargesField.getText().isEmpty()){
					overallExpense += Double.parseDouble(lodgingChargesField.getText());
					given += 95 * days;
				}
				if(!taxiChargesField.getText().isEmpty()) {
					overallExpense += Double.parseDouble(taxiChargesField.getText());
					given += 20 * days;
				}
				
				double needsPaid = overallExpense - given;
				if(needsPaid < 0) needsPaid = 0;
				
				double saved = overallExpense - needsPaid;
				if(saved < 0) saved = 0;
				
				JOptionPane.showMessageDialog(null, 
						"Results:\n" + 
						"Total expenses - " + NumberFormat.getCurrencyInstance().format(overallExpense) + "\n" +
						"Applicable savings - " + NumberFormat.getCurrencyInstance().format(given) + "\n" +
						"Needs to be paid - " + NumberFormat.getCurrencyInstance().format(needsPaid) + "\n" +
						"Money saved - " + NumberFormat.getCurrencyInstance().format(saved));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "All values must be numbers.");
			}
		}
	}

}
