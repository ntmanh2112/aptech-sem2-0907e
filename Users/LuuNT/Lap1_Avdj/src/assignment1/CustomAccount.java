package assignment1;

public class CustomAccount {

	private double baLanCe;
	private String accountType;
	
	/*
	 * 
	 */
	public CustomAccount(String accountType, double baLanCe ) {
		this.accountType = accountType;
		this.baLanCe = baLanCe;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return baLanCe;
	}

	public void setBalance(double baLanCe) {
		this.baLanCe = baLanCe;
	}
}
