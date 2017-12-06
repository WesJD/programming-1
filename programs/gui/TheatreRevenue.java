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

public class TheatreRevenue extends JFrame {
	
	private final double PERCENTAGE = .20;
	private final JTextField adultTicketPrice;
	private final JTextField adultTickets;
	private final JTextField childrensTicketPrice;
	private final JTextField childrensTickets;
	
	private TheatreRevenue() {
		adultTicketPrice = new JTextField(5);
		adultTickets = new JTextField(5);
		childrensTicketPrice = new JTextField(5);
		childrensTickets = new JTextField(5);
		
		final FlowLayout layout = new FlowLayout();
		setTitle("Theatre Revenue");
		setSize(1050, 100);
		setResizable(false);
		setLayout(layout);
		
		final JPanel panel = new JPanel();
		panel.setLayout(layout);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Revenue"));
		panel.add(new JLabel("Adult ticket price"));
		panel.add(adultTicketPrice);
		panel.add(new JLabel("Number of adult tickets"));
		panel.add(adultTickets);
		panel.add(new JLabel("Childrens ticket price"));
		panel.add(childrensTicketPrice);
		panel.add(new JLabel("Number of childrens tickets"));
		panel.add(childrensTickets);
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
		new TheatreRevenue();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				double adultRevenue = 0;
				if(!adultTicketPrice.getText().isEmpty()) 
					adultRevenue = Double.parseDouble(adultTicketPrice.getText()) * Integer.parseInt(adultTickets.getText());
				
				double childrensRevenue = 0;
				if(!childrensTicketPrice.getText().isEmpty()) 
					childrensRevenue = Double.parseDouble(childrensTicketPrice.getText()) * Integer.parseInt(childrensTickets.getText());
				
				JOptionPane.showMessageDialog(null, 
						"Adult revenue - " + NumberFormat.getInstance().format(adultRevenue) + "\n" +
						"Net adult revenue - " + NumberFormat.getInstance().format(adultRevenue - (adultRevenue * PERCENTAGE)) + "\n" + 
						"Childrens revenue - " + NumberFormat.getInstance().format(childrensRevenue) + "\n" +
						"Net childrens revenue - " + NumberFormat.getInstance().format(childrensRevenue - (childrensRevenue * PERCENTAGE)) + "\n" + 
						"Total revenue - " + NumberFormat.getInstance().format(adultRevenue + childrensRevenue) + "\n" +
						"Total net revenue - " + NumberFormat.getInstance().format((adultRevenue + childrensRevenue) - ((adultRevenue + childrensRevenue) * PERCENTAGE)));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "The fields need to be numbers");
			}
		}
	}

}
