package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.elements.AddExpensePane;
import project.elements.ExpenseListPane;
import project.elements.TrackerMenuBar;

public class ExpenseTracker extends JFrame {
	
	private final int PADDING = 10;
	private final boolean DEBUG = false;
	
	private final MemoryManager memoryManager = new MemoryManager();
	private final ExpenseListPane expenseListPane;
	
	private ExpenseTracker() {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> memoryManager.saveToFile()));
		setResizable(false);
		setTitle("Expense Tracker");
		setJMenuBar(new TrackerMenuBar(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(232, 224, 153));
		panel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
		panel.setLayout(new BorderLayout());
		panel.add(new AddExpensePane(this), BorderLayout.NORTH);
		panel.add(expenseListPane = new ExpenseListPane(this), BorderLayout.SOUTH);
		add(panel);
		
		pack();
		setVisible(true);
	}
	
	public void debug(String message) {
		if(DEBUG) System.out.println(message);
	}
	
	public ExpenseListPane getExpenseListPane() {
		return expenseListPane;
	}
	
	public MemoryManager getMemoryManager() {
		return memoryManager;
	}
	
	public static void main(String[] args) {
		new ExpenseTracker();
	}

}
