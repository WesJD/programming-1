package elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import project.ExpenseTracker;

public class ExpenseListPane extends JPanel {
	
	private final Color PANEL_COLOR = new Color(255, 254, 181);
	
	private final ExpenseTracker tracker;
	private final JTable table;
	private final JButton removeButton;
	
	public ExpenseListPane(ExpenseTracker tracker) {
		this.tracker = tracker;
		
		setLayout(new BorderLayout());
		setBackground(PANEL_COLOR);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredSoftBevelBorder(), "Manage Expenses"));
		
		table = new JTable() {
			@Override
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        }
	    };
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.getSelectionModel().addListSelectionListener(new SelectionListener());
	    table.setBackground(PANEL_COLOR);

		refreshTable();
		add(table, BorderLayout.NORTH);
		
		add(Box.createRigidArea(new Dimension(0, 7)), BorderLayout.CENTER);
		
		removeButton = new JButton("Remove");
		removeButton.setBackground(new Color(216, 232, 153));
		removeButton.setEnabled(false);
		removeButton.addActionListener(new ButtonListener());
		add(removeButton, BorderLayout.SOUTH);
	}
	
	public void refreshTable() {
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new Object[] { "Name", "Cost" });
		
		final Map<String, Double> expenses = tracker.getMemoryManager().getExpenses();
		for(String key : expenses.keySet()) tableModel.addRow(new Object[] { key, NumberFormat.getCurrencyInstance().format(expenses.get(key)) });
		
		table.setModel(tableModel);
		tracker.pack();
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tracker.getMemoryManager().removeExpense((String) table.getValueAt(table.getSelectedRow(), 0));
			refreshTable();
			removeButton.setEnabled(false);
		}
	}
	
	private class SelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			removeButton.setEnabled(true);
		}
	}

}
