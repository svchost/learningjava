import java.io.Serializable;

public class SavingsAccount extends account implements INTRESTACCOUNT {
    public SavingsAccount(String accountNumber) {
        super(accountNumber, AccountType.SAVINGS);
    }

    @Override
    public void addMonthlyInterest() {
        // Can access protected method from parent
        applyInterest(0.05);
    }
}