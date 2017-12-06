import javax.swing.JOptionPane;

import static java.lang.String.format;

public class Eggs2 {
	
	private Eggs2() {
		final int eggAmount = requestIntSafely("How many eggs do you have?");
		final int leftOver = eggAmount % 12;
		if(leftOver > 0) showAnswer(format("You have %s dozen(s) and %s left over eggs.", (eggAmount - leftOver) / 12, leftOver));
		else showAnswer(format("You have %s dozen(s) of eggs.", eggAmount / 12));
		System.exit(0);
	}
	
	private int requestIntSafely(String prompt) {
		final String input = JOptionPane.showInputDialog(prompt);
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			JOptionPane.showInputDialog("Invalid input: " + prompt);
			return requestIntSafely(prompt);
		}
	}
	
	private void showAnswer(String message) {
		JOptionPane.showMessageDialog(null, message, "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		new Eggs2();
	}

}
