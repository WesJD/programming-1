import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class NumberValidator {

	private final int[] VALID_NUMBERS = new int[] { 5658845, 4520125, 7895122, 8777451, 8451277, 1302850, 8080152, 4562555 };
	private final String WELCOME_MESSAGE = "Enter the number in which you would like to check. Type QUIT to quit.";
	
	public NumberValidator() {
		final Scanner scanner = new Scanner(System.in);
		out.println(WELCOME_MESSAGE);
		while(true) {
			out.print("> ");

			final String input = scanner.next();
			if(input.equalsIgnoreCase("quit"))break;
			else {
				try {
					int value = Integer.parseInt(input);
					if(isValid(value)) out.println("That number is valid!");
					else out.println("That number is not valid!");
				} catch(Exception ex) {
					out.println("You must input a number to check.");
					continue;
				}
				out.println(WELCOME_MESSAGE);
			}
		}
		out.println("Goodbye.");
		scanner.close();
	}

	private boolean isValid(int number) {
		return Arrays.stream(VALID_NUMBERS)
				.filter(num -> num == number)
				.count() >= 1;
	}

	public static void main(String[] args) {
		new NumberValidator();
	}

}
