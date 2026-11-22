public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Michał", "Zbyniek");
        Person person2 = new Person("Kalantai", "Kalasznikow");
        Person person3 = new Person("Andrzej", "Muchov");

        Receipt[] accounts = {
                new Receipt(person1, 1000.0),
                new Account(person2, 2000.0),
                new AccountVIP(person3, 3000.0, 3.0, -500.0)
        };

        accounts[0].deposit(100.0);
        accounts[1].withdraw(200.0);
        accounts[2].transfer(accounts[0], 500.0);
        Account.changeRate(4.0);

        for (Receipt receipt : accounts) {
            receipt.update();
            System.out.println(receipt);
        }
    }
}