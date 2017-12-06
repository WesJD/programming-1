import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;

import javax.swing.JOptionPane;

public class Pennies {
	
	private Pennies() {
		final int days = requestTypeSafely("How many days did you work?", (input) -> {
			final int parsed = Integer.parseInt(input);
			if(parsed <= 0) throw new RuntimeException("Input must be > 0");
			return parsed;
		});
		
		final NumberFormat testFormat = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
		final DecimalFormat format = new DecimalFormat("\u00A4#.##");
		
		final StringBuilder table = new StringBuilder("{day}: {salary}\n");
		double salary = 0.01D;
		for(int i=1; i <= days; i++) {
			table.append(i).append(": ").append(format.format(salary)).append("\n");
			salary += salary;
		}
		
		table.append("\n").append("Total salary (format) is ").append(format.format(salary));
		table.append("\n").append("Total salary (testFormat) is ").append(testFormat.format(salary));
		
		JOptionPane.showMessageDialog(null, table.toString(), "Response", JOptionPane.INFORMATION_MESSAGE);
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
		new Pennies();
	}

}
