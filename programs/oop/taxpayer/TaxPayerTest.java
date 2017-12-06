public class TaxPayerTest {
	
	private TaxPayerTest() {
		final TaxPayer[] taxPayers = new TaxPayer[10];
		int ssn = 434765897;
		double income = 10000;
		for(int i=0; i < taxPayers.length; i++) {
			final TaxPayer next = new TaxPayer(ssn++, income);
			income += 10000;
			taxPayers[i] = next;
			System.out.println("Tax payer with SSN of " + next.getSocialSecurityNumber() + 
					" has a gross income of " + next.getGrossIncome());
		}
	}
	
	public static void main(String[] args) {
		new TaxPayerTest();
	}
	
}
