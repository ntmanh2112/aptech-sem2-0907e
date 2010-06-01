package Labs2;
public class Account
{
// The first way: synchronize a method
/*
public synchronized void deposit(double amount)
{
System.out.println("Step 1: check amount");
System.out.println("Step 2: transaction processing");
// Process
try {
Thread.sleep(3000);
} catch(Exception e) {}
System.out.println("Step 3: deposited " + amount);
}
*/
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
/*
synchronized(acc) {
acc.deposit(amount);
}
*/
}
}
