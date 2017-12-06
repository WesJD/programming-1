import javax.swing.JOptionPane;

import static java.lang.String.format;

public class Payroll {
	
	private Payroll() {
		final double hourlyRate = requestDoubleSafely("What is your hourly rate?");
		final double hoursWorked = requestDoubleSafely("How many hours did you work?");
		final double grossPay = hourlyRate * hoursWorked;
		final double withholding = grossPay * 15 / 100;
		JOptionPane.showMessageDialog(null, 
				format(
						"Your gross pay is $%s\n" +
						"With a withholding tax of $%s\n" +
						"Results in your net pay being $%s",
						grossPay, withholding, grossPay - withholding
				),
				"Answer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double requestDoubleSafely(String request) {
		try {
			return Double.parseDouble(JOptionPane.showInputDialog(request));
		} catch (NumberFormatException ex) {
			return requestDoubleSafely("Invalid input. " + request);
		}
	}
	
	public static void main(String[] args) {
		new Payroll();
	}

}
