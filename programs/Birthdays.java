import java.util.function.Function;

import javax.swing.JOptionPane;

public class Birthdays {
	
	private Birthdays() {
		final int month = requestTypeSafely("What month were you born?", Integer::parseInt);
		final int day = requestTypeSafely("What day were you born?", Integer::parseInt);
		final int year = requestTypeSafely("What year were you born?", this::parseDateInput);
		
		int total = (year / 4) + year + day;
		switch(month) {
			case 1: //january
			case 10: //october
				total += 1;
				break;
			case 2: //feburary
			case 3: //march
			case 11: //november
				total += 4;
				break;
			case 9: //september
			case 12: //december
				total += 6;
				break;
			case 6: //june
				total += 5;
				break;
			case 5: //may
				total += 2;
				break;
			case 8: //august
				total += 3;
				break;
		}
		if((year % 4 == 0) && (month <= 2)) total--;
		
		String dayOfWeek = "Brokenday";
		switch(total % 7) {
			case 1:
				dayOfWeek = "Sunday";
				break;
			case 2:
				dayOfWeek = "Monday";
				break;
			case 3:
				dayOfWeek = "Tuesday";
				break;
			case 4:
				dayOfWeek = "Wednesday";
				break;
			case 5:
				dayOfWeek = "Thursday";
				break;
			case 6:
				dayOfWeek = "Friday";
				break;
			case 7:
				dayOfWeek = "Saturday";
				break;
		}
		
		showResponse("You were born on " + dayOfWeek + ".");
	}
	
	private void showResponse(String message) {
		JOptionPane.showMessageDialog(null, message, "Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private int parseDateInput(String input) {
		final int requested = Integer.parseInt(input);
		if(requested < 1900 || requested > 1999) throw new RuntimeException("Invalid year.");
		return getLastTwoDigits(requested);
	}
	
	private int getLastTwoDigits(int number) {
		final String stringValue = Integer.toString(number);
		if(stringValue.length() >= 2) return Integer.parseInt(stringValue.substring(stringValue.length() - 2));
		else throw new RuntimeException("Number must have at least two digits.");
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
		new Birthdays();
	}

}
