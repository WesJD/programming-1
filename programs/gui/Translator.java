import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Translator extends JFrame {
	
	private final JButton greenButton;
	private final JButton blueButton;
	
	public Translator() {
		final ButtonListener listener = new ButtonListener();
		greenButton = new JButton("Green");
		greenButton.addActionListener(listener);
		blueButton = new JButton("Blue");
		blueButton.addActionListener(listener);
		
		add(greenButton);
		add(blueButton);
		
		setLayout(new FlowLayout());
		setTitle("Dictionary");
		setSize(200, 100);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource().equals(greenButton)) {
				if(greenButton.getText().equals("Green")) greenButton.setText("Vert");
				else greenButton.setText("Green");
			} else if(event.getSource().equals(blueButton)) {
				if(blueButton.getText().equals("Blue")) blueButton.setText("Bleu");
				else blueButton.setText("Blue");
			}
		}
		
	}

	public static void main(String[] args) {
		new Translator();
	}

}
