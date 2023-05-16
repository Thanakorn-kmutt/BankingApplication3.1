
package bankingapplication3;

public class SavingAccount {
    private int accountNumber;
    private String accountName;
    private double balance;
    private final String accountType = "SavingsAccount";
    
    public SavingAccount(int accountNumber, String accountName, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountName(){
        return this.accountNumber;
    }
    
    @Override
    public void deposit(){
        this.balance = this.balance + amount;
    }
    
    @Override
    public void withdraw(){
        this.balance = this.balance - amount;
    }
    
    @Override
    public double getBalance(){
        return this.balance;
    }
    
    @Override
    public String getaccountType(){
        return this.accountType;
    }
}
