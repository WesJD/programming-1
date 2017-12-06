import javax.swing.JOptionPane;

import static java.lang.String.format;

public class Salary {
	
	private final int AMOUNT_PER_HOUR = 25;
	private final double OVERTIME_AMOUNT_PER_HOUR = AMOUNT_PER_HOUR * 1.5;
	
	private Salary() {
		final int regularSalary = requestIntSafely("How many non-overtime hours did you work?") * AMOUNT_PER_HOUR;
		final double overtimeSalary = requestIntSafely("How many overtime hours did you work?") * OVERTIME_AMOUNT_PER_HOUR;
		showAnswer(format(
				"Your regular salary is $%s\n" +
				"Your overtime salary is $%s\n" +
				"Your total gross salary is $%s",
				regularSalary, overtimeSalary, regularSalary + overtimeSalary
			));
	}
	
	private int requestIntSafely(String prompt) {
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(prompt));
		} catch (NumberFormatException ex) {
			JOptionPane.showInputDialog("Invalid input: " + prompt);
			return requestIntSafely(prompt);
		}
	}
	
	private void showAnswer(String message) {
		JOptionPane.showMessageDialog(null, message, "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		new Salary();
	}

}
