package Labs2;

public class BankTransaction {
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



