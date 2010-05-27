package Assignment1;

public class CustomerAccount {
	private  String accountType;
	private double balance;
 public CustomerAccount(String name,Double balance){
	 setAccountType(name);
	 this.balance=balance;
 }
 public void setAccountType(String accountType) {
	this.accountType = accountType;
}
 public void setBalance(double balance) {
	this.balance = balance;
}
 public double getBalance() {
	return balance;
}
 public String getAccountType() {
	return accountType;
}
 

	
		
	
	 
	 

 

 
}

