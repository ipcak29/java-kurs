package org.homework;

import org.homework.generator.HoldingGenerator;
import org.homework.model.*;
import org.homework.model.Account;
import org.homework.model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();
    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);

    public static void main(String[] args) {
//        System.out.println(getHoldingsWhereAreCompanies());
//        System.out.println(getHoldingNames());
//        System.out.println(getHoldingNamesAsString());
//        System.out.println(getCompaniesAmount());
//        System.out.println(getAllUserAmount());
//
//        LinkedList<String> companyNames = getAllCompaniesNamesAsLinkedList();
//        System.out.println(companyNames);
//        System.out.println(getUsersForPredicate(user -> user.getSex() == Sex.WOMAN));
//        System.out.println( getRichestWoman());
//        System.out.println(getFirstNCompany(3));

//        getUserPerCompany().forEach((company, users) ->
//                System.out.println(company + ": " + users.size() + " użytkowników"));
//        System.out.println(getUser(user -> true).getFirstName());
//        System.out.println(createAccountsMap().keySet());
//        System.out.println(getUserNames());
//        showAllUser();
//        System.out.println(getCurenciesSet());
//        executeForEachCompany(company -> System.out.println(company.getName()));

        ////exercise7
//        Predicate<Integer> even = number -> number % 2 == 0;
//        System.out.println(filterNumbers(numbers, even));
//
//        Function<String, String> deleteSpaces = String::trim;
//        Function<String, String> upperCase = String::toUpperCase;
//        Function<String, String> deleteSpacesAndUpperCase = deleteSpaces.andThen(upperCase);
//        System.out.println(deleteSpacesAndUpperCase.apply(" hello world "));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jason", 18, "Kotłownia"));
        employees.add(new Employee("Adams", 26, "Kotłownia"));
        employees.add(new Employee("Peter", 33, "Wózkowy"));
        employees.add(new Employee("Angel", 23, "Stołówka"));

        List<String> stremEmployees = employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .map(Employee::getName)
                .sorted()
                .toList();

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(employeesByDepartment);
        System.out.println(stremEmployees);

    }
////filtrowanie
    public static List<Integer> filterNumbers(
            List<Integer> numbers,
            Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(holding -> !holding.getCompanies().isEmpty())
                .count();
    }

    /**
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(Holding::getName)
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.toList());
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        return getHoldingNames().stream()
                .sorted()
                .collect(Collectors.joining(", ", "(", ")"));
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return getCompanyStream()
                .count();
    }


    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return getUserStream()
                .count();
    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return getCompanyStream()
                .map(Company::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return getUserStream()
                .filter(userPredicate)
                .map(User::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        getCompanyStream()
                .forEach(consumer);

    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return getUserStream()
                .filter(user -> user.getSex() == Sex.WOMAN)
                .max(Comparator.comparing(Exercises::getUserAmountInPLN));
    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return user.getAccounts()
                .stream()
                .map(Exercises::getAccountAmountInPLN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return getCompanyStream()
                .limit(n)
                .map(Company::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return getCompanyStream()
                .collect(Collectors.toMap(Company::getName, Company::getUsers));
    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return getUserStream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return getAccoutStream()
                .collect(Collectors.toMap(Account::getNumber, account -> account));
    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return getUserStream()
                .map(User::getFirstName)
                .distinct()
                .collect(Collectors.joining(" "));
    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        System.out.println(getUserStream()
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "))
        );
    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return getAccoutStream()
                .map(Account::getCurrency)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }
}
