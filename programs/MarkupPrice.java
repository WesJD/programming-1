import java.util.function.Function;

import javax.swing.JOptionPane;


public class MarkupPrice {

	public MarkupPrice() {
		final double base = requestTypeSafely("What is the base price?", Double::parseDouble);
		final double markup = requestTypeSafely("What is the markup percentage?", 
				(input) -> Double.parseDouble(input) / 100.0);
		JOptionPane.showMessageDialog(null, "The total price with markup is $" + calculateRetail(base, markup));
	}
	
	private double calculateRetail(double base, double markup) {
		return base + (base * markup);
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
		new MarkupPrice();
	}

}
