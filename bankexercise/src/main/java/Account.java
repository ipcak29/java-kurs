public class Account extends Receipt {
    private static double rate;

    public Account(Person owner, double accountBalance) {
        super(owner, accountBalance);
    }

    public static void changeRate(double newRate) {
        Account.rate = newRate;
    }

    public void update() {
        double interest = getAccountBalance() * rate / 100;
        setAccountBalance(getAccountBalance() + interest);
    }

    @Override
    public String toString() {
        return getPerson() + " " + getAccountBalance() + " " + rate;
    }
}