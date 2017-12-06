import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoesMotive extends JFrame {
	
	private final JCheckBox oilChangeSelection;
	private final JCheckBox lubeJobSelection;
	private final JCheckBox radiatorFlushSelection;
	private final JCheckBox transmissionFlushSelection;
	private final JCheckBox inspectionSelection;
	private final JCheckBox mufflerReplacementSelection;
	private final JCheckBox tireRotationSelection;
	private final JTextField extraPartsField;
	private final JTextField extraHoursField;
	
	public JoesMotive() {
		oilChangeSelection = new JCheckBox("Oil Change");
		lubeJobSelection = new JCheckBox("Lube Job");
		radiatorFlushSelection = new JCheckBox("Radiator Flush");
		transmissionFlushSelection = new JCheckBox("Transmission Flush");
		inspectionSelection = new JCheckBox("Inspection");
		mufflerReplacementSelection = new JCheckBox("Muffler Replacement");
		tireRotationSelection = new JCheckBox("Tire Roatation");
		extraPartsField = new JTextField();
		extraPartsField.setPreferredSize(new Dimension(35, 25));
		extraHoursField = new JTextField();
		extraHoursField.setText("0");
		extraHoursField.setPreferredSize(new Dimension(30, 25));
		
		final FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setTitle("Joe's Automotive");
		setSize(815, 160);
		setResizable(false);
		
		final JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Standard Services"));
		selectionPanel.setLayout(layout);
		selectionPanel.add(oilChangeSelection);
		selectionPanel.add(lubeJobSelection);
		selectionPanel.add(radiatorFlushSelection);
		selectionPanel.add(transmissionFlushSelection);
		selectionPanel.add(inspectionSelection);
		selectionPanel.add(mufflerReplacementSelection);
		selectionPanel.add(tireRotationSelection);
		add(selectionPanel);
		
		final JPanel extraServicesPanel = new JPanel();
		extraServicesPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Extra Services"));
		extraServicesPanel.setLayout(layout);
		extraServicesPanel.add(new JLabel("Parts Price"));
		extraServicesPanel.add(extraPartsField);
		extraServicesPanel.add(new JLabel("Labor Hours ($12/hr)"));
		extraServicesPanel.add(extraHoursField);
		add(extraServicesPanel);
		
		add(Box.createRigidArea(new Dimension(100, 0)));
		
		final JButton calculateButton = new JButton("Calculate Bill");
		calculateButton.setPreferredSize(new Dimension(120, 35));
		calculateButton.addActionListener(new ButtonListener());
		add(calculateButton);
		
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double totalCost = 0;
			if(oilChangeSelection.isSelected()) totalCost += 26;
			if(lubeJobSelection.isSelected()) totalCost += 18;
			if(radiatorFlushSelection.isSelected()) totalCost += 30;
			if(transmissionFlushSelection.isSelected()) totalCost += 80;
			if(inspectionSelection.isSelected()) totalCost += 15;
			if(mufflerReplacementSelection.isSelected()) totalCost += 100;
			if(tireRotationSelection.isSelected()) totalCost += 20;
			
			final String extaPartsValue = extraPartsField.getText();
			if(!extaPartsValue.isEmpty()) {
				final int partsValue;
				try {
					partsValue = Integer.parseInt(extaPartsValue);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Extra parts value must be a number.");
					return;
				}
				
				final int hoursWorked;
				try {
					hoursWorked = Integer.parseInt(extraHoursField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Extra hours worked must be a number.");
					return;
				}
				
				totalCost += partsValue;
				totalCost += (12 * hoursWorked);
			}
			
			JOptionPane.showMessageDialog(null, "Your bill total will be $" + totalCost + ".");
		}
	}
	
	public static void main(String[] args) {
		new JoesMotive();
	}

}
