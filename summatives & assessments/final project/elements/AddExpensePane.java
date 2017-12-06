package elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.ExpenseTracker;

public class AddExpensePane extends JPanel {
	
	private final Color PANEL_COLOR = new Color(255, 254, 181);
	
	private final ExpenseTracker tracker;
	private final JTextField nameField;
	private final JTextField costField;
	
	public AddExpensePane(ExpenseTracker tracker) {
		this.tracker = tracker;
		nameField = new JTextField(7);
		costField = new JTextField(3);
		
		setLayout(new BorderLayout());
		setBackground(PANEL_COLOR);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredSoftBevelBorder(), "Add Expense"));
		
		final JPanel top = new JPanel();
		top.setBackground(PANEL_COLOR);
		top.add(new JLabel("Name "));
		top.add(nameField);
		add(top, BorderLayout.WEST);
		
		final JPanel mid = new JPanel();
		mid.setBackground(PANEL_COLOR);
		mid.add(new JLabel("Cost  $"));
		mid.add(costField);
		add(mid, BorderLayout.EAST);
		
		final JButton button = new JButton("Add");
		button.setBackground(new Color(216, 232, 153));
		button.addActionListener(new ButtonListener());
		add(button, BorderLayout.SOUTH);
		tracker.getRootPane().setDefaultButton(button);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(nameField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must supply a valid expense name.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else if(tracker.getMemoryManager().isExpense(nameField.getText())) {
				JOptionPane.showMessageDialog(null, "An expense with that name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			final double cost;
			try {
				cost = Double.parseDouble(costField.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "The expense cost must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			tracker.getMemoryManager().addExpense(nameField.getText(), cost);
			nameField.setText("");
			nameField.requestFocus();
			costField.setText("");
			tracker.getExpenseListPane().refreshTable();
		}
	}

}
