import java.util.function.Function;

import javax.swing.JOptionPane;

public class Weather {
	
	private Weather() {
		final int temperature = requestTypeSafely(int.class, "What is the temperature?", Integer::parseInt);
		final boolean sunny = requestTypeSafely(boolean.class, "Is it sunny? (true/false)", Boolean::parseBoolean);
		
		String response = null;
		if(temperature >= 70 && sunny) response = "Head to the beach.";
		else if(!sunny) response = "Bring your umbrella!";
		
		if(response != null) JOptionPane.showMessageDialog(null, response, "Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private <T> T requestTypeSafely(Class<T> type, String prompt, Function<String, T> conversion) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			return requestTypeSafely(type, "Invalid answer. " + prompt, conversion);
		}
	}

	public static void main(String[] args) {
		new Weather();
	}
	
}
