package UnitedBank;
import javax.swing.*;
public class TransferManager {
	CustomerAccount[] bankaccount=new CustomerAccount[20];
    int current=0;

public TransferManager(){
    
    int choice=0;
    
    while(choice!=3){
        choice=Integer.parseInt(JOptionPane.showInputDialog("1. Create an Acc\n 2.Acc Info\n 3.Exit \nPls choise:"));
        switch(choice){
            case 1:
                          
                        bankaccount[current]=new CustomerAccount();
                        bankaccount[current].setAccount(JOptionPane.showInputDialog("PLs input name:"));
                        bankaccount[current].setBalance(Float.parseFloat(JOptionPane.showInputDialog("PLs input balance:")));
                        JOptionPane.showMessageDialog(null,"your name: "+bankaccount[current].getAccount()+" your balance: "+bankaccount[current].getBalance());
                        current++;
                   break;
            case 2:
                 action();
                 break;
            case 3:
                JOptionPane.showMessageDialog(null,"you are exiting");
                break;
            default:
                JOptionPane.showMessageDialog(null,"bad choice");
                break;
            }
        }
                
                        
    }
    public void action(){
            String x=JOptionPane.showInputDialog("Pls input your Acc:");
           
            for(int i=0; i<=current;i++ ){
                   if(x.equalsIgnoreCase(bankaccount[i].getAccount())){
                       int actionchoice=0;
                       while(actionchoice!=3){
                        actionchoice=Integer.parseInt(JOptionPane.showInputDialog("your name: "+bankaccount[i].getAccount()+" your balance: "+bankaccount[i].getBalance()+"" +
                        "\n1. Withdraw\n 2.Deposit \n3.main menu"));
                        switch(actionchoice){
                            case 3:
                                break;
                            case 1:
                               Withdraw(i);
                                break;
                            case 2:
                               Deposit(i);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"bad choice");
                                break;
                        }
                       }
                   break;
                   }
              }



    }
       public void Withdraw(int i){
          float bl=bankaccount[i].getBalance();
          float m;
          String str=JOptionPane.showInputDialog("The sum of money you want to withdraw:");
          m=Float.parseFloat(str);

          float rs=bl-m;
          bankaccount[i].setBalance(rs);
       
       }

       public void Deposit(int i){
          float bl=bankaccount[i].getBalance();
          float m;
          String str=JOptionPane.showInputDialog("The sum of money you want to deposit:");
          m=Float.parseFloat(str);

          float rs=bl+m;
          bankaccount[i].setBalance(rs);

       }


    public static void main(String[] arg){
    	TransferManager run=new TransferManager ();
    	
    }

    }