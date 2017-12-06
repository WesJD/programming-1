import javax.swing.JOptionPane;

import static java.lang.String.format;

public class Money {
	
	private Money() {
		final int totalMoney = requestIntSafely("How much money do you have (no cents)?");
		int currentAmount = totalMoney;
		final int twenties = (currentAmount - (currentAmount % 20)) / 20;
		currentAmount -= twenties * 20;
		final int tens = (currentAmount - (currentAmount % 10)) / 10;
		currentAmount -= tens * 10;
		final int fives = (currentAmount - (currentAmount % 5)) / 5;
		currentAmount -= fives * 5;
		showAnswer(format("You'll end up with %s twenties, %s tens, %s fives, and %s ones", twenties, tens, fives, currentAmount));
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
		new Money();
	}

}
