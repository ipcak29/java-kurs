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
}
