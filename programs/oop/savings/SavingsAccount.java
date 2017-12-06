public class SavingsAccount {
	
	private double balance;
	private double annualInterestRate;
	
	public SavingsAccount(double balance, double annualInterestRate) {
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void widthdrawl(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void addMonthlyInterest() {
		balance += balance * (annualInterestRate / 12);
	}

}
