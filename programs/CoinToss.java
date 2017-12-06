import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import javax.swing.JOptionPane;


public class CoinToss {
	
	private CoinToss() {
		final int flips = requestTypeSafely("How many times do you want to toss?", Integer::parseInt);
		int heads = 0, tails = 0;
		for(int i=0; i < flips; i++) {
			switch(ThreadLocalRandom.current().nextInt(2)) {
				case 0: 
					heads++;
					break;
				case 1:
					tails++;
					break;
				default:
					throw new RuntimeException("Error");
			}
		}
		JOptionPane.showMessageDialog(null, "There were " + heads + " heads and " + tails + " tails.");
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
		new CoinToss();
	}

}
