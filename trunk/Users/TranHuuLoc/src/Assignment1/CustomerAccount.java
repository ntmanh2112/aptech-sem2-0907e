package Assignment1;

public class CustomerAccount {
	private  String accountType;
	private Integer balance;
 public CustomerAccount(String name,Integer balance){
	 setAccountType(name);
	 this.balance=balance;
 }
 public void setAccountType(String accountType) {
	this.accountType = accountType;
}
 public void setBalance(Integer balance) {
	this.balance = balance;
}
 public double getBalance() {
	return balance;
}
 public String getAccountType() {
	return accountType;
}
 

	
		
	
	 
	 

 

 
}

