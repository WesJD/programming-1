import java.util.function.Function;

import javax.swing.JOptionPane;


public class RestaurantBill {
	
	private RestaurantBill() {
		final double total = requestTypeSafely("What was the bill amount?", Double::parseDouble);
		final double tax = getTax(total);
		final double tip = getTip(total);
		JOptionPane.showMessageDialog(null, 
				"Tax (6.75%) = $" + prettyRound(tax) + "\n" +
				"Tip (15%) = $" + prettyRound(tip) + "\n\n" +
				"Your bill total will be $" + prettyRound(total + tip + tax) + "."
		);
	}
	
	private double prettyRound(double value) {
		return (double) Math.round(value * 100D) / 100D;
	}
	
	private double getTax(double billTotal) {
		return billTotal * 0.0675D;
	}
	
	private double getTip(double billTotal) {
		return billTotal * 0.15;
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
		new RestaurantBill();
	}

}
