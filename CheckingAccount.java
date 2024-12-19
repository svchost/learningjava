import java.io.Serializable;

public class CheckingAccount extends account implements AccountOverdarftProtection {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber) {
        super(accountNumber, AccountType.CHECKING);
        this.overdraftLimit = 0.0;
    }

    @Override
    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit;
    }

    @Override
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        validateAmount(amount);
        if (amount > balance + overdraftLimit) {
            throw new IllegalArgumentException("Exceeds overdraft limit. The maximum amount is " + getOverdraftLimit());
        }
        balance -= amount;
    }
}