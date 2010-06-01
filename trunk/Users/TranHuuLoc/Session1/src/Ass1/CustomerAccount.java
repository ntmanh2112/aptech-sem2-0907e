package Ass1;
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
 
 public void nhapAccount() {
	 double temp=0.0;
	 Scanner input= new Scanner(System.in);
	 System.out.println("nhap ten account: ");
	 setAccountType(input.next());
	 System.out.println("nhap tien vao: ");
	 
	 try {
		temp=input.nextDouble();
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	 
	 while(temp<=0) { 
		 System.out.println("ban da nhap sai moi ban nhap lai ");
		 temp=input.nextDouble();
	 } 
	 setBalance(temp);
	 
 }

 
}
