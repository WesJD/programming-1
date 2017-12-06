import java.util.function.Function;

import javax.swing.JOptionPane;

public class ISP {
	
	private ISP() {
		final String welcomeMessage = 
				"Package A: $9.95/mo with 10 hours of access. Additional hours are $2/hr.\n" +
				"Package B: $13.95/mo with 20 hours of access. Additional hours are $1/hr.\n" + 
				"Package C: $19.95/mo with unlimited hours of access. Addtional hours are at no cost.\n" +
				"\n" + 
				"Please enter the selected package.";
		final char packageLetter = requestTypeSafely(welcomeMessage, this::parsePackageLetter);
		final double hoursUsed = requestTypeSafely("How many hours were used?", Double::parseDouble);
		
		double charge = -Double.MAX_VALUE;
		if(packageLetter == 'A') charge = getCharge(9.95D, 2D, 10, hoursUsed);
		else if(packageLetter == 'B') charge = getCharge(13.95D, 1D, 20, hoursUsed);
		else if(packageLetter == 'C') charge = 19.95D;
		
		JOptionPane.showMessageDialog(null, "You will have to pay $" + charge + " this month", 
				"Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double getCharge(double monthlyCharge, double overtimeCharge, int givenHours, double hoursUsed) {
		return monthlyCharge + (hoursUsed > givenHours ? (hoursUsed - givenHours) * overtimeCharge : 0);
	}
	
	private char parsePackageLetter(String input) {
		final char firstChar = input.charAt(0);
		if(firstChar == 'A' || firstChar == 'B' || firstChar == 'C') return firstChar;
		else throw new RuntimeException("Not a valid package letter.");
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer.\n\n") + prompt, conversion, true);
		}
	}
	
	public static void main(String[] args) {
		new ISP();
	}

}
