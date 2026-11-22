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
        if (recipient == null || amount <= 0) {
            return false;
        } else if (accountBalance < amount) {
            return false;
        }
        if( recipient.deposit(amount)){
        accountBalance -= amount;
        return true;
        }
        return false;
    }

    public void update(){
        System.out.println("Basic receipt");
    }

    @Override
    public String toString() {
        return owner + " " + accountBalance;
    }
}