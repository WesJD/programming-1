import java.util.Scanner;

public class Calculator {
	
	private Calculator() {
		final Scanner scanner = new Scanner(System.in);
		requestInput("What is the amount?");
		final double amount = readDoubleSafely(scanner);
		requestInput("What is the percent?");
		final double percent = readDoubleSafely(scanner);
		println("The discounted amount is %s", amount - (amount * (percent * .01)));
		System.exit(0);
	}
	
	private double readDoubleSafely(Scanner scanner) {
		final String input = scanner.nextLine();
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException ex) {
			println("Please supply a valid double.");
			System.out.print("> ");
			return readDoubleSafely(scanner);
		}
	}
	
	private void requestInput(String request) {
		println(request);
		System.out.print("> ");
	}
	
	private void println(String input, Object... params) {
		System.out.println(String.format(input, params));
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
