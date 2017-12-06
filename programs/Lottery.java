import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static java.lang.System.out;

public class Lottery {
	
	private final Scanner SCANNER = new Scanner(System.in);
	
	private Lottery() {
		final int[] winningNumbers = new int[5];
		for(int i=0; i<winningNumbers.length; i++) winningNumbers[i] = ThreadLocalRandom.current().nextInt(10);
		
		final int[] userNumbers = new int[winningNumbers.length];
		for(int i=0; i<winningNumbers.length; i++) {
			userNumbers[i] = requestTypeSafely("What number for slot #" + (i+1) + "?", (in) -> {
				final int input = Integer.parseInt(in);
				if(input > 9) throw new RuntimeException();
				else return input;
			});
		}
		
		int totalCorrect = 0;
		for(int i=0; i<userNumbers.length; i++) {
			String value = "incorrect";
			if(winningNumbers[i] == userNumbers[i]) {
				value = "correct";
				totalCorrect++;
			}
			out.println("For slot #" + (i+1) + ", you were " + value + ".");
		}
		if(totalCorrect == userNumbers.length) out.println("You got all the answers correct! GRAND PRIZE WINNER!");
		else out.println("Unfortunantely, you were not a grand prize winner.");
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			System.out.println(prompt);
			System.out.print("> ");;
			return conversion.apply(SCANNER.next());
		} catch (Exception ex) {
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer.\n\n") + prompt, conversion, true);
		}
	}
	
	public static void main(String[] args) {
		new Lottery();
	}

}
