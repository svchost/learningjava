public class SavingsAccount extends account {
    public SavingsAccount(String accountNumber) {
        super(accountNumber, AccountType.SAVINGS);
    }

    public void addMonthlyInterest() {
        // Can access protected method from parent
        applyInterest(0.05);
    }
}