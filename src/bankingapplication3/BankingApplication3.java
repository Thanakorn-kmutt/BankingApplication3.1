package bankingapplication3;

import java.util.Random;
import java.util.Scanner;


public class BankingApplication3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0, accountNumber;
        Bank bank = new Bank("AAA");
        String accountName, accountType;
        double balance, amount, minimum = 10;
        Account account;
        
        while(option !=6){
            System.out.println("Main menu");
            System.out.println("1. Display all accounts");
            System.out.println("2. Open new account");
            System.out.println("3. Close existing account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw"); 
            System.out.println("6. Exit");
            
            System.out.println("Enter your choice: ");
            option = scan.nextInt();
            
            switch(option) {
                case 1:
                    bank.listAccount();
                    break;
                    
                case 2:
                    accountNumber = generateAccountNumber();
                    System.out.println("Enter Account Name: ");
                    accountName = scan.nextLine();
                    System.out.println("Enter Initial Balance");
                    balance = scan.nextDouble();
                    System.out.println("Enter Account: (s or c)");
                    accountType = scan.nextLine();
                    
                    if (accountType.toLowerCase().equals("s")){
                        account = new SavingsAccount(accountNumber, accountName, balance);
                    }
                    else if (accountType.toLowerCase().equals("c")){
                        account = new CurrentAccount(accountNumber, accountName, balance);
                    }
                    
                    account = new Account(accountNumber, accountName, balance); 
                    bank.openAccount(account);
                    break;
                    
                case 3:
                    System.out.println("Enter Account Number");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type (s or c)");
                    accountType = scan.nextLine();
                    
                    if (accountType.toLowerCase().equals("s")){
                        account = bank.getAccount(accountNumber, "SavingsAccount");
                    }
                    else if (accountType.toLowerCase().equals("c")){
                        account = bank.getAccount(accountNumber, "CurrentAccount");
                    }                    
                    
                    bank.closeAccount(account);
                    System.out.println("Account is Deleted");
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type (s or c)");
                    accountType = scan.nextLine();
                    
                    if (accountType.toLowerCase().equals("s")){
                        accountType = "SavingsAccount";
                    }
                    else if (accountType.toLowerCase().equals("c")){
                        accountType = "CurrentAccount";
                    }             
                    account = bank.getAccount(accountNumber, accountType);
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(account, amount);
                    break;
                    
                case 5:
                    System.out.println("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type (s or c)");
                    accountType = scan.nextLine();
                    
                    if (accountType.toLowerCase().equals("s")){
                        accountType = "SavingsAccount";
                    }
                    else if (accountType.toLowerCase().equals("c")){
                        accountType = "CurrentAccount";
                    }             
                    account = bank.getAccount(accountNumber, accountType);
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.withdrawMoney(account, amount);
                    break;
                    
            }
            
        }
        
    }
    
    public static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 100000 + random.nextInt(900000);
        return accNumber;
    }
}
