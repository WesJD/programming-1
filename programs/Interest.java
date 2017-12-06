import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Interest {
	
	private final double PRINCIPAL_AMOUNT = 1000D;
	private final double INTEREST_RATE = 0.05D;
	private final int YEARS = 10; 
	
	private Interest() {
		final DecimalFormat df = new DecimalFormat("\u00A4#.##");
		final StringBuilder sb = new StringBuilder("{year}: {amount on deposit}");
		for(int i=0; i<=YEARS; i++) {
			sb.append("\n")
			  .append(i)
			  .append(": ")
			  .append(df.format(getDepositAmount(PRINCIPAL_AMOUNT, INTEREST_RATE, i)));
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}
	
	private double getDepositAmount(double principal, double interestRate, int years) {
		return principal * Math.pow(1 + interestRate, years);
	}
	
	public static void main(String[] args) {
		new Interest();
	}

}
