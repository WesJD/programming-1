import java.util.function.Function;

import javax.swing.JOptionPane;


public class IRS {
	
	private IRS() {
		final int maritialStatus = requestTypeSafely("What is your maritial status? (0-single, 1-married)", 
				(input) -> {
					final int parsed = Integer.parseInt(input);
					if(parsed < 0 || parsed > 1) throw new RuntimeException("Invalud maritial status");
					return parsed;
				});
		final double taxableIncome = requestTypeSafely("What is your taxable income?", Double::parseDouble);
		double taxed = 0;
		if(maritialStatus == 0) {
			if(taxableIncome > 297350) taxed = tax(taxableIncome, 93374, 0.391, 297350);
			else if(taxableIncome > 136750) taxed = tax(taxableIncome, 36361, 0.355, 136750);
			else if(taxableIncome > 65550) taxed = tax(taxableIncome, 14645, 0.305, 65550);
			else if(taxableIncome > 27050) taxed = tax(taxableIncome, 4057.5, 0.275, 27050);
			else if(taxableIncome > 0) taxed = tax(taxableIncome, 0, 0.15, 0);
		} else {
			if(taxableIncome > 297350) taxed = tax(taxableIncome, 88306, 0.391, 297350);
			else if(taxableIncome > 166500) taxed = tax(taxableIncome, 41855, 0.355, 166500);
			else if(taxableIncome > 109250) taxed = tax(taxableIncome, 24393.75, 0.305, 109250);
			else if(taxableIncome > 45200) taxed = tax(taxableIncome, 6780, 0.275, 45200);
			else if(taxableIncome > 0) taxed = tax(taxableIncome, 0, 0.15, 0);
		}
		JOptionPane.showMessageDialog(null, "Your Federal tax is $" + taxed + ".", "Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public double tax(double income, double initial, double percent, double over) {
		return initial + (percent * (income-over));
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			ex.printStackTrace();
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer.\n\n") + prompt, conversion, true);
		}
	}
	
	public static void main(String[] args) {
		new IRS();
	}

}
