import java.text.DecimalFormat;
import java.util.function.Function;

import javax.swing.JOptionPane;


public class SalesTax {
	
	private final DecimalFormat FORMAT = new DecimalFormat("#.##");

	public SalesTax() {
		final double purchaseAmount = requestTypeSafely("What is the purchase amount?", Double::parseDouble);
		final double stateTax = calculateStateTax(purchaseAmount);
		final double countyTax = calculateCountyTax(purchaseAmount);
		JOptionPane.showMessageDialog(null, "State tax: " + stateTax + "\nCounty tax: " 
		  + countyTax + "\n\nTotal: " + FORMAT.format((purchaseAmount + stateTax + countyTax)));
	}
	
	private double calculateStateTax(double purchaseAmount) {
		return purchaseAmount * 0.06;
	}
	
	private double calculateCountyTax(double purchaseAmount) {
		return purchaseAmount * 0.02;
	}
	
	private <T> T requestTypeSafely(String ask, Function<String, T> conversion) {
		return requestTypeSafely(ask, conversion, false);
	}
	
	private <T> T requestTypeSafely(String ask, Function<String, T> conversion, boolean failed) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(ask));
		} catch (Exception ex) {
			return requestTypeSafely((failed ? "Invalid anser.\n\n" : "") + ask, conversion, true);
		}
	}

	public static void main(String[] args) {
		new SalesTax();
	}

}
