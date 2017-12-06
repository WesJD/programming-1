import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import javax.swing.JOptionPane;


public class GuessingGame {
	
	private GuessingGame() {
		int wins = 0, losses = 0;
		String endStatus;
		do {
			final int maxValue = requestTypeSafely("What should the max guess value be?", Integer::parseInt);
			final int guessable = ThreadLocalRandom.current().nextInt(maxValue) + 1;
			final int maxGuesses = requestTypeSafely("What should the max amount of guesses be?", Integer::parseInt);
			String nextMessage = "Enter your guess.";
			for(int i=0; i<maxGuesses; i++) {
				final int guessed = requestTypeSafely(nextMessage, Integer::parseInt);
				if(guessed < guessable) nextMessage = "Your guess is too small, guess again.";
				else if(guessed > guessable) nextMessage = "Your guess is too big, guess again.";
				else {
					endStatus = "You have won!";
					wins++;
					return;
				}
			}
			endStatus = "You have ran out of guesses.";
			losses++;
		} while(requestTypeSafely(endStatus + " Do you want to play again? (true/false)", Boolean::parseBoolean));
		JOptionPane.showMessageDialog(null, "You won " + wins + " time(s) and lost " + losses + " time(s).");
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
		new GuessingGame();
	}

}
