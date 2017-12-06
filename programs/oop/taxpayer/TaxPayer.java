public class TaxPayer {
	
	private final int ssn;
	private final double grossIncome;
	
	public TaxPayer(int ssn, double grossIncome) {
		super();
		this.ssn = ssn;
		this.grossIncome = grossIncome;
	}

	public int getSocialSecurityNumber() {
		return ssn;
	}

	public double getGrossIncome() {
		return grossIncome;
	}
	
}
