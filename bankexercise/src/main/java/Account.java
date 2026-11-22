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

// Wszystkie konta klasy Konto mają wspólne oprocentowanie. Klasa Konto
// przedefiniowuje następujące metody (z klasy Rachunek): aktualizacja() -aktualizującą stan konta
// po doliczeniu odsetek na podstawie bieżącego oprocentowania oraz toString(...).