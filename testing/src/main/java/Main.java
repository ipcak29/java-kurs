import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static List<Order> orders = List.of(
            new Order(1, "Adam", "COMPLETED",
                    List.of("Laptop", "Mouse"), 4200),
            new Order(2, "Anna", "COMPLETED",
                    List.of("Keyboard", "Mouse"), 350),
            new Order(3, "Adam", "CANCELLED",
                    List.of("Monitor"), 1200),
            new Order(4, "Piotr", "COMPLETED",
                    List.of("Laptop", "Monitor"), 5500),
            new Order(5, "Anna", "COMPLETED",
                    List.of("Mouse", "Headphones"), 600),
            new Order(6, "Adam", "COMPLETED",
                    List.of("Keyboard", "Monitor"), 1500)
    );

    public static void main(String[] args) {
        String products = orders.stream()
                .filter(s -> s.status().equals("COMPLETED"))
                .flatMap(s -> s.products().stream())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        Map<String, List<Integer>> customerOrders = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.mapping(Order::id,
                                Collectors.toList()
                        )));

        Map<String, Double> customerSpendings = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .collect(Collectors.toMap(
                        Order::customer,
                        Order::total,
                        Double::sum
                ));

        List<Integer> topOrdersById = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .sorted(Comparator.comparingDouble(
                        Order::total).reversed())
                .limit(3)
                .map(Order::id)
                .toList();

        System.out.println(topOrdersById);
    }
}