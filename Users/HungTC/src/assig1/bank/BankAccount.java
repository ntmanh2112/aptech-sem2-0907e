/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Lesson2.Account.bank;

/**
 *
 * @author PC001
 */
public class BankAccount {
 
  private double balance;
  private String Account;

  public BankAccount(){}
  public BankAccount(String acc, double bal){
  this.Account=acc;
  this.balance=bal;
  }
    public String getAccount() {
        return Account;
    }

    public double getBalance() {
        return balance;
    }

  
    public void setAccount(String Account) {
        this.Account = Account;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}


