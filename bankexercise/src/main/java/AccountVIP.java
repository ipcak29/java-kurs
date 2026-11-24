public class AccountVIP extends Account {
    private final double individualRate;
    private final double debtLimit;

    public AccountVIP(Person owner, double accountBalance, double individualRate, double debtLimit) {
        super(owner, accountBalance);
        this.individualRate = individualRate;
        this.debtLimit = debtLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0 || getAccountBalance() - amount < debtLimit) {
            return false;
        }
        setAccountBalance((getAccountBalance() - amount));
        return true;
    }

    @Override
    public boolean transfer(Receipt recipient, double amount) {
        return recipient != null && withdraw(amount) && recipient.deposit(amount);
    }

    @Override
    public void update() {
        double interest = getAccountBalance() * individualRate / 100;
        setAccountBalance(getAccountBalance() + interest);
    }

    @Override
    public String toString() {
        return "Owner: %s, Balance: %s, Individual Rate:%s, Debt Limit:%s".formatted(getPerson(),
                getAccountBalance(), individualRate, debtLimit);
    }
}