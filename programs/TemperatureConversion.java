import java.util.function.Function;

import javax.swing.JOptionPane;


public class TemperatureConversion {
	
	private TemperatureConversion() {
		JOptionPane.showMessageDialog(null, "That in fahrenheit is " + 
				toCelsius(requestTypeSafely("What is your celsius value?", Double::parseDouble)));
	}
	
	private int toCelsius(double fahrenheit) {
		return (int) (fahrenheit-32) * 5/9;
		
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
		new TemperatureConversion();
	}

}
