package bankingapplication3;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bank {
    private String bankname;
    
    
    public Bank(String name){
        this.bankname = bankname;
    }
    
    public void listAccount(Account account) {
        Connection con = BankConnection.connect();
        try{
            Statement statement = con.createStatement();
            String sql = "Select * from account";
            ResultSet results = statement.executeQuery(sql);
        
            while(results.next()){
                System.out.println(results.getString(1)+" "+results.getString(2)+" "+results.getString(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void openAccount(Account account) {
        Connection con = BankConnection.connect();
        String sql = "insert into account(accID,accName,accBalance,accType) values(?,?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getAccountType());
            preparedStatement.executeUpdate();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    
    public void closeAccount(int Number) {
        Connection con = BankConnection.connect();
        String sql = "Delete account from where accID = ?";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,number);
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void depositMoney(Account account, double amount) {
        account.deposit(amount);    
        Connection con = BankConnection.connect();
        String sql = "UPDATE student set accBalance = ? where accID = ? ";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void withdrawMoney(Account account, double amount) {
        account.deposit(amount);
        Connection con = BankConnection.connect();
        String sql = "UPDATE student set accBalance = ? where accID = ? ";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Account getAccount(int accountNumber, String accountType){
        Connection con = BankConnection.connect();
        Account account = null;
        String sql = "select * from account where accID = ? AND accType = ?";
            
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, accountNumber);
            preparedStatement.setInt(2, accountType);
            ResultSet result = preparedStatement.executeQuery();
            
            result.next();
            String accountName = result.getString(2);
            double balance = result.getDouble(3);
            
            if (accountType.equals("SavingsAccount")){
                account = new SavingsAccount(accountNumber, accountName, balance);
            }
            else if(accountType.equals("CurrentAccount")){
                account = new CurrentAccount(accountNumber, accountName, balance);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
        
        
    }

}
