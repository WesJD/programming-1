import java.util.function.Function;

import javax.swing.JOptionPane;


public class MagicDate {
	
	private MagicDate() {
		final int month = requestTypeSafely(int.class, "What is the month number?", Integer::parseInt);
		final int day = requestTypeSafely(int.class, "What is the the day number?", Integer::parseInt);
		final int year = requestTypeSafely(int.class, "What is the year number?", (input) -> Integer.parseInt(input.substring(2)));
		String response;
		if(month * day == year) response = "That is a magic date!";
		else response = "That is not a magic date.";
		JOptionPane.showMessageDialog(null, response, "Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private <T> T requestTypeSafely(Class<T> type, String prompt, Function<String, T> conversion) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			return requestTypeSafely(type, "Invalid answer. " + prompt, conversion);
		}
	}
	
	public static void main(String[] args) {
		new MagicDate();
	}

}
