import javax.swing.JOptionPane;

public class GPA {
	
	private GPA() {
		final double gpa = requestDoubleSafely("What is your GPA?");
		JOptionPane.showMessageDialog(null, gpa > 3.5 ? "You can be accepted." : "You cannot be accepted.");
	}
	
	private double requestDoubleSafely(String prompt) {
		final String input = JOptionPane.showInputDialog(prompt);
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException ex) {
			return requestDoubleSafely("Incorrect answer." + prompt);
		}
	}
	
	public static void main(String[] args) {
		new GPA();
	}
	
}
