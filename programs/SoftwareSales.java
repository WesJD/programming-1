import java.util.function.Function;

import javax.swing.JOptionPane;

public class SoftwareSales {
	
	private SoftwareSales() {
		final int packagesPurchased = requestTypeSafely("What is the amount of packages purchased?", Integer::parseInt);
		int discount = 0;
		if(packagesPurchased >= 10) {
			if(packagesPurchased <= 19) discount = 20;
			else if(packagesPurchased <= 49) discount = 30;
			else if(packagesPurchased <= 99) discount = 40;
			else discount = 50;
		}
		JOptionPane.showMessageDialog(null, 
				"You ordered " + packagesPurchased + " packages and got a " + discount + 
				  "% discount resulting in a total price of $" + 
				  ((99 * packagesPurchased) * (discount > 0 ? (discount * .01) : 1)),
				"Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			return requestTypeSafely("Invalid answer. " + prompt, conversion);
		}
	}
	
	public static void main(String[] args) {
		new SoftwareSales();
	}

}
