import java.util.function.Function;

import javax.swing.JOptionPane;


public class Products {
	
	private Products() {
		final int input = requestTypeSafely("Enter your number.", Integer::parseInt);
		final StringBuilder sb = new StringBuilder("{iteration}: {value}");
		
		int product = input;
		int iterations = 0;
		while(product < 100) {
			sb.append("\n").append(iterations).append(": ").append(product);
			product = product*10;
			iterations++;
		}
		
		JOptionPane.showMessageDialog(null, sb.append("\nTotal of ").append(iterations).append(" iterations").toString());
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
		new Products();
	}

}
