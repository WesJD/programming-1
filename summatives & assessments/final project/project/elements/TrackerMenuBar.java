package project.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import project.ExpenseTracker;

public class TrackerMenuBar extends JMenuBar {
	
	public TrackerMenuBar(ExpenseTracker tracker) {
		final JMenu fileMenu = new JMenu("File");
		
		final JMenuItem resetItem = new JMenuItem("Reset");
		resetItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tracker.getMemoryManager().reset();
				tracker.getExpenseListPane().refreshTable();
			}
		});
		fileMenu.add(resetItem);
		
		fileMenu.addSeparator();
		
		
		final JMenuItem reloadItem = new JMenuItem("Reload");
		reloadItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tracker.setVisible(false);
					Thread.sleep(30000);
					tracker.setVisible(true);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});
		reloadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.ALT_MASK));
		fileMenu.add(reloadItem);
		
		final JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tracker.debug("saving");
				tracker.getMemoryManager().saveToFile();
			}
		});
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileMenu.add(saveItem);
		
		fileMenu.addSeparator();
		
		final JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tracker.setVisible(false);
				tracker.dispose();
			}
		});
		fileMenu.add(exitItem);

		add(fileMenu);
	}

}
