package lab1;


class Account 
{ 
 
	public void deposit(double amount) 
	{ 
		System.out.println("Step 1: check amount"); 
 
		System.out.println("Step 2: transaction processing"); 
 
  try { 
   Thread.sleep(3000); 
  } catch(Exception e) {} 
 
  		System.out.println("Step 3: deposited " + amount); 
 } 
 

 public double getBalance() 
 { 
  return 0; 
 } 
} 
 
 

class DepositTransaction implements Runnable 
{ 
 private Account acc; 
 private double amount; 
 
 DepositTransaction(Account acc, double amount) { 
  this.acc = acc; 

  this.amount = amount; 
 } 
 
 public void run() 
 { 
  System.out.println("Deposit money"); 

  acc.deposit(amount); 
  
 } 
} 
 
public class BankTransaction 
{ 
 public static void main(String a[]) 
 { 
  Account acc = new Account(); 
  Account acc2 = new Account(); 
 
  Thread t1 = new Thread(new DepositTransaction(acc, 1000)); 
  Thread t2 = new Thread(new DepositTransaction(acc2, 2000)); 
  Thread t3 = new Thread(new DepositTransaction(acc, 2000)); 
  t1.start(); 
  t2.start(); 
  t3.start(); 
 } 
} 
