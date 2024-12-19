import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        accountvalidator accountvalidator = new accountvalidator();

        while(true) {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();


            if (!accountvalidator.isValidAccountNumber(accountNumber)) {
                System.out.println("Account number is incorrect " + accountNumber);
                return;
            }

            System.out.print("PICK ACCOUNT TYPE: 1. Checking: 2. Saving: ");
            int accountTypee = scanner.nextInt();

            AccountOperations account;
            switch (accountTypee) {
                case 1:
                    account = new CheckingAccount(accountNumber);
                    System.out.println("this is a checking account");
                    if (account instanceof AccountOverdarftProtection) {
                        System.out.print("Set overdraft limit: ");
                        double limit = scanner.nextDouble();
                        ((AccountOverdarftProtection) account).setOverdraftLimit(limit);
                        System.out.println("Overdraft limit set to: " + limit);
                    }
                    break;
                case 2:
                    account = new SavingsAccount(accountNumber);
                    System.out.println("this is a saving account");
                    break;
                default:
                    System.out.println("Invalid account type");
                    return;
            }

            System.out.print("PICK ACCOUNT ACTION: 1. DEPOSIT: 2. WITHDRAW: ");
            int accountaction = scanner.nextInt();
            switch (accountaction) {
                case 1:
                    System.out.print("ENTER DEPOSIT AMOUNT: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        account.deposit(depositAmount);
                        System.out.println("deposit successful: " + depositAmount);
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("ENTER WITHDRAWAL AMOUNT: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawalAmount);
                        System.out.println("withdrawal successful: " + withdrawalAmount);
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid account action");
                    return;
            }
            System.out.println("New Balance: " + account.getBalance());

            if (account instanceof INTRESTACCOUNT) {
                ((INTRESTACCOUNT) account).addMonthlyInterest();
                System.out.println("Interest Added. New balance: " + account.getBalance());
            }


            try {
                System.out.println("System is restarting please wait 5 seconds before typing");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
