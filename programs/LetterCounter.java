import java.util.function.Function;

import javax.swing.JOptionPane;


public class LetterCounter {
	
	private LetterCounter() {
		final String input = JOptionPane.showInputDialog("Input a word");
		final char check = requestTypeSafely("Enter a letter to check for.", (in) -> {
			if(in.length() > 1) throw new RuntimeException("Must be only a single letter.");
			return in.charAt(0);
		});
		int occurances = 0;
		for(char c : input.toCharArray()) if(c == check) occurances++;
		JOptionPane.showMessageDialog(null, "There are " + occurances + " occurances of \"" + check + "\"");
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
		new LetterCounter();
	}

}
