import java.util.Scanner;

import static java.lang.System.out;

public class CharacterCounter {

	public CharacterCounter() {
		final Scanner scanner = new Scanner(System.in);
		out.println("Enter a series of numbers without spaces.");
		out.print("> ");
		final char[] chars = scanner.nextLine().toCharArray();
		int sum = 0;
		for(char c : chars) sum += Integer.parseInt(c+"");
		out.println("The user input was a total of " + chars.length + " characters with a sum of " + sum);
		scanner.close();
	}

	public static void main(String[] args) {
		new CharacterCounter();
	}

}
