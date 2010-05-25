package UnitedBank;

public class CustomerAccount {
	private float balance;
	  private String Account;

	  public CustomerAccount(){}
	    public String getAccount() {
	        return Account;
	    }

	    public float getBalance() {
	        return balance;
	    }

	  
	    public void setAccount(String Account) {
	        this.Account = Account;
	    }

	    public void setBalance(float balance) {
	        this.balance = balance;
	    }

}
