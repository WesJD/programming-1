import java.util.Scanner;
import java.util.function.Function;

public class TestScores2 {
	
	private final Scanner SCANNER = new Scanner(System.in);
	
	private TestScores2() {
		final double[] scores = new double[7];
		int total = 0;
		for(int i=0; i<scores.length; i++) {
			final double input = requestTypeSafely("What was you test score for test #" + (i + 1) + "?", Double::parseDouble);
			scores[i] = input;
			total += input;
		}
		System.out.println("Your average was " + (total/scores.length));
		SCANNER.close();
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
		new TestScores2();
	}

}
