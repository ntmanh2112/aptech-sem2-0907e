 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson2.Account.bank;
import javax.swing.*;

/**
 *
 * @author chihung
 */
public class BankRun {
    int size=10;
    BankAccount[] bankaccount=new BankAccount[size];
    int current=0, plus=1;
public BankRun(){
     
  int choice=0;
  while(choice!=3){

        try{choice=Integer.parseInt(JOptionPane.showInputDialog("1. Create an Acc\n 2.Acc Info\n 3.Exit \nPls choose:"));}
    	catch(Exception e)
        {choice=0;}
    
    	switch(choice){

        case 1:
               CreateAcc();
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

public void CreateAcc(){
    if(current==size)
      JOptionPane.showMessageDialog(null, "out of array size");
    else{
      String str=  JOptionPane.showInputDialog("Pls input name:");
      for(int j=0;j<=current;j++){
          try{if(str.equalsIgnoreCase(bankaccount[j].getAccount()))
                 {   JOptionPane.showMessageDialog(null, "acc name has been used. Your acc will be: "+str+plus);
                 str=str+plus;
                 plus+=1;
                 break;
                 }}
          catch(Exception e){}
     }
                    
      double bal=0;
      try  { bal=Double.parseDouble(JOptionPane.showInputDialog("Pls input balance:"));                  	}
      catch(Exception e){ JOptionPane.showMessageDialog(null,"the balance must be a number");   }
                    
      bankaccount[current]=new BankAccount(str,bal);
      JOptionPane.showMessageDialog(null,"your name: "+bankaccount[current].getAccount()+" & your balance: "+bankaccount[current].getBalance());
      current++;
  }
}


public void action(){
       String x=JOptionPane.showInputDialog("Pls input your Acc:");
       int flag=0;
       for(int i=0; i<bankaccount.length;i++ ){
           try{if(x.equalsIgnoreCase(bankaccount[i].getAccount()))
                {flag=1;
                menu(i);
                break;}}
           catch(Exception e){}
       }
       if(flag==0)
       JOptionPane.showMessageDialog(null,"the acc isn't found");
  }


public void menu(int i){
         int actionchoice=0;
         while(actionchoice!=3)
         {
          try{actionchoice=Integer.parseInt(JOptionPane.showInputDialog(i+" your name: "+bankaccount[i].getAccount()+" your balance: "+bankaccount[i].getBalance()+"" +
          "\n1. Withdraw\n 2.Deposit \n3.main menu"));}
          catch(Exception e)
          {actionchoice=0;}
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
}


public void Withdraw(int i){
      double bl=bankaccount[i].getBalance();
      double  m=0;
      String str=JOptionPane.showInputDialog("The sum of money you want to withdraw:");
      
      try {m=Double.parseDouble(str);}
      catch(Exception e){JOptionPane.showMessageDialog(null, "the money is not a number");}

      if(m>=0){
      double rs=bl-m;
        if(rs>=0)
        bankaccount[i].setBalance(rs);
        else
        JOptionPane.showMessageDialog(null,"you don't have enough money");
      }
      else
         JOptionPane.showMessageDialog(null,"the money must be greater than 0");
   }


    public void Deposit(int i){
      double bl=bankaccount[i].getBalance();
      double m=0;
      String str=JOptionPane.showInputDialog("The sum of money you want to deposit:");
      
      try {m=Double.parseDouble(str);}
      catch(Exception e){JOptionPane.showMessageDialog(null, "the money is not a number");}
      if(m>=0){
      double rs=bl+m;
      bankaccount[i].setBalance(rs);
      }
      else
         JOptionPane.showMessageDialog(null,"the money must be greater than 0");
      }


public static void main(String[] arg){
    new BankRun();
}

}