package ass1;
import java.util.*;
public class CustomerAccount {
	private  String accountType="";
	private double balance;
 public CustomerAccount(){
	 
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
 
 public void input() {
	 double temp=0.0;
	 Scanner input= new Scanner(System.in);
	 System.out.println("please enter your account type: ");
	 setAccountType(input.next());
	 System.out.println("please enter your balance amount: ");
	 
	 try {
		temp=input.nextDouble();
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	 
	 while(temp<=0) { 
		 System.out.println("you have just entered wrong numbers: " + temp + "please try again: ");
		 temp=input.nextDouble();
	 } 
	 setBalance(temp);
	 
 }

 
}
