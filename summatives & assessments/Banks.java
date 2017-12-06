import java.util.function.Function;

import javax.swing.JOptionPane;


public class Banks {

	private Banks() {
		final int amountOfChecks = requestTypeSafely("How many checks were written?", Integer::parseInt);
		double serviceFee = 10;
		if(amountOfChecks < 20) serviceFee += (0.10 * amountOfChecks);
		else if(amountOfChecks <= 39) serviceFee += (0.08 * amountOfChecks);
		else if(amountOfChecks <= 59) serviceFee += (0.06 * amountOfChecks);
		else serviceFee += (0.04 * amountOfChecks);
		JOptionPane.showMessageDialog(null, 
				"You had " + amountOfChecks + " checks and have to pay a total of $" + formatToMoney(serviceFee),
				"Answer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private String formatToMoney(double amount) {
		final String stringValue = Double.toString(amount);
		final int substringIndex = stringValue.indexOf('.') + 1;
		
		final StringBuilder sb = new StringBuilder(stringValue.substring(substringIndex));
		if(sb.length() < 2) sb.append("0");
		else if(sb.length() > 2) while(sb.length() > 2) sb.deleteCharAt(sb.length());
		sb.insert(0, stringValue.substring(0, substringIndex));
		
		return sb.toString();
	}
	
	private <T> T requestTypeSafely(String message, Function<String, T> conversion) {
		return requestTypeSafely(message, conversion, false);
	}
	
	private <T> T requestTypeSafely(String message, Function<String, T> conversion, boolean wasErrored) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(message));
		} catch (Exception ex) {
			return requestTypeSafely((wasErrored ? "" : "Invalid input.\n\n") + message, conversion, true);
		}
	}

	public static void main(String[] args) {
		new Banks();
	}

}
