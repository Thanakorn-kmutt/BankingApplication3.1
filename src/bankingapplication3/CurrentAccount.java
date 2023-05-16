package bankingapplication3;

public class CurrentAccount {
   private int accountNumber;
   private String accountName;
   private double balance;
   private double minimum;
   private String accountType = "CurrentAccount";

    public CurrentAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.minimum = 0;
    }
    
    public int getNumber(){
        return this.accountNumber;
    }
    
    public String getAccountName(){
        return this.accountName;
    }
    
    public double getMinimum(){
        return this.minimum;
    }
    
    public void setMinimum(double minimum){
        this.minimum = minimum;
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
