import java.text.NumberFormat;
import java.util.Scanner;
import java.util.function.Function;

public class SavingsTest {
	
	private final Scanner SCANNER = new Scanner(System.in);
	
	private SavingsTest() {
		final double startingAmount = requestTypeSafely("What is the starting amount?", Double::parseDouble);
		final double annualInterestRate = 
				requestTypeSafely("What is the annual interest percentage?", Double::parseDouble) / 100;
		final int months = requestTypeSafely("How many months has the money been in the account?", Integer::parseInt);
		final SavingsAccount account = new SavingsAccount(startingAmount, annualInterestRate);
		for(int i=1; i<=months; i++) {
			System.out.println("---------- [ MONTH " + i + " ] ----------");
			account.widthdrawl(requestTypeSafely("How much did you widthdrawl this month?", Double::parseDouble));
			account.deposit(requestTypeSafely("How much did you deposit this month?", Double::parseDouble));
			account.addMonthlyInterest();
			System.out.println("Your balance is now " + 
					NumberFormat.getCurrencyInstance().format(account.getBalance()));
		}
		System.out.println("The account now has a total balance of " + 
				NumberFormat.getCurrencyInstance().format(account.getBalance()));
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
		new SavingsTest();
	}

}
