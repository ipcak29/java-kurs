public class Receipt {
    private final Person owner;
    private double accountBalance;

    public Receipt(Person owner, double accountBalance) {
        this.owner = owner;
        this.accountBalance = accountBalance;
    }

    public Person getPerson() {
        return owner;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Receipt recipient, double amount) {
        return recipient != null && withdraw(amount) && recipient.deposit(amount);
    }

    public void update() {
        System.out.println("Basic receipt");
    }

    @Override
    public String toString() {
        return "Owner: %s, Balance: %s".formatted(owner, accountBalance);
    }
}