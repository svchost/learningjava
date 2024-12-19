public class account implements AccountOperations {
    // Private fields with getter/setter pattern
    protected double balance;
    private String accountNumber;
    private AccountType accountType;

    // Public constructor - accessible everywhere
    public account(String accountNumber, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 100.0;
    }

    // Public constructor - accessible everywhere
    public account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 100.0;
    }

    // Public methods - interface for other classes
    @Override
    public double getBalance() {
        return balance;
    }

    public AccountType GetType() {
        return accountType;
    }

    @Override
    public void deposit(double amount) {
        validateAmount(amount);
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        validateAmount(amount);
        this.balance -= amount;
    }

    // Private helper method - internal use only
    protected void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    // Protected method - accessible by subclasses
    protected void applyInterest(double rate) {
        this.balance *= (1 + rate);
    }
}


