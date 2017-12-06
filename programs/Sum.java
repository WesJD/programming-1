import java.util.function.Function;

import javax.swing.JOptionPane;


public class Sum {
	
	private Sum() {
		final int value = requestTypeSafely("Enter a positive, nonzero integer value.", (input) -> {
			final int parsed = Integer.parseInt(input);
			if(parsed <= 0) throw new RuntimeException("Number must be positive nonzero.");
			return parsed;
		});
		int sum = 0;
		for(int i=1; i <= value; i++) sum+=i;
		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Response", JOptionPane.INFORMATION_MESSAGE);
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
		new Sum();
	}

}
