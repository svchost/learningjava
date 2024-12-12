import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        accountvalidator accountvalidator = new accountvalidator();

        System.out.print("Enter account number: ");
        String Accountnumber = scanner.next();

        SavingsAccount savingaccount = new SavingsAccount(Accountnumber);
        CheckingAccount checkingaccount = new CheckingAccount(Accountnumber);

        if(accountvalidator.isValidAccountNumber(Accountnumber))
            System.out.println("Account number is correct " + Accountnumber);
        else System.out.println("Account number is incorrect " + Accountnumber);



            //System.out.println("AccountType: " + savingaccount.GetType());

        System.out.print("PICK ACCOUNT TYPE: 1. Checking: 2. Saving: ");
        int accountTypee = scanner.nextInt();




       switch (accountTypee){
           case 1:
               //checking
               System.out.print("THISISCHECKING");
              System.out.println("ACCOUNT ACTION: 1. Deposit: 2. Withdraw: ");
               int checkingacc = scanner.nextInt();
            switch (checkingacc) {
                case 1:
                    System.out.print("DEPOSITING, ENTER AMOUNT YOU WANT TO DEPOSIT: ");
                    int number = scanner.nextInt();
                    checkingaccount.deposit(number);
                    System.out.println("Successfully deposited: " + number);
                    System.out.println("New balance " + checkingaccount.getBalance());
                    break;
                    case 2:
                        System.out.print("WITHDRAWING, ENTER AMOUNT YOU WANT TO WITHDRAW: ");
                        int withdrawal = scanner.nextInt();
                        checkingaccount.withdraw(withdrawal);
                        System.out.println("Successfully withdrawn: " + withdrawal);
                        System.out.println("New balance " + checkingaccount.getBalance());
                        break;
                        default:
                            System.out.println("Invalid Action selected.");
                            return;
                }
                break;
                case 2:
                    //savings
                    System.out.print("THISISSAVINGS");
                    System.out.println("ACCOUNT ACTION: 1. Deposit: 2. Withdraw: ");
                    int savingacc = scanner.nextInt();
                    switch (savingacc) {
                        case 1:
                            System.out.print("DEPOSITING, ENTER AMOUNT YOU WANT TO DEPOSIT: ");
                            int savingamount = scanner.nextInt();
                            savingaccount.deposit(savingamount);
                            System.out.println("Successfully deposited: " + savingamount);
                            System.out.println("New balance " + savingaccount.getBalance());
                            savingaccount.addMonthlyInterest();
                            System.out.println("New balance AfterInterest " + savingaccount.getBalance());
                            break;
                        case 2:
                            System.out.print("WITHDRAWING, ENTER AMOUNT YOU WANT TO WITHDRAW: ");
                            int withdrawingamount = scanner.nextInt();
                            savingaccount.withdraw(withdrawingamount);
                            System.out.println("Successfully withdrawn: " + withdrawingamount);
                            savingaccount.addMonthlyInterest();
                            System.out.println("New balance " + savingaccount.getBalance());
                            break;
                        default:
                            System.out.println("Invalid Action selected.");
                            return;
                    }
                        break;
                    default:
                    System.out.println("Invalid account type selected.");
               return;
            }
       }

    }
