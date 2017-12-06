import java.util.Scanner;

public class Eggs {
	
	private Eggs() {
		final Scanner scanner = new Scanner(System.in);
		requestInput("How many total eggs do you have?");
		final int eggAmount = readIntSafely(scanner);
		final int leftOver = eggAmount % 12;
		if(leftOver > 0) println("You have %s dozen(s) and %s left over eggs.", (eggAmount - leftOver) / 12, leftOver);
		else println("You have %s dozen(s) of eggs.", eggAmount / 12);
		System.exit(0);
	}
	
	private int readIntSafely(Scanner scanner) {
		final String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			println("Please supply a valid int.");
			System.out.print("> ");
			return readIntSafely(scanner);
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
		new Eggs();
	}

}
