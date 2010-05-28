package ass1;

public class CustomerAccount {
	private String accountType;
	private double balance;
	public CustomerAccount(String acc,double bal){
		this.accountType = acc;
		this.balance = bal;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
