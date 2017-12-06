import java.util.Scanner;
import java.util.function.Function;

public class SubstanceTest {
	
	private final Scanner SCANNER = new Scanner(System.in);
	
	private SubstanceTest() {
		final int temperature = requestTypeSafely("Enter a temperature", Integer::parseInt);
		System.out.println("This temperature...");
		for(TemperaturePoint point : TemperaturePoint.values()) {
			System.out.println("- Can " + (!point.canFreezeAt(temperature) ? "not " : "") + "freeze if it is " + point);
			System.out.println("- Can " + (!point.canBoilAt(temperature) ? "not " : "") + "boil if it is " + point);
		}
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
		new SubstanceTest();
	}

}
