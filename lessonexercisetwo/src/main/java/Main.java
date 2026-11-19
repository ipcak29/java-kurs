import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    List<Employee> employees = List.of(
            new Employee(1, "Adam", "IT", 28, 8500),
            new Employee(2, "Anna", "HR", 35, 7200),
            new Employee(3, "Piotr", "IT", 42, 12500),
            new Employee(4, "Kasia", "HR", 29, 6800),
            new Employee(5, "Marek", "IT", 31, 9500),
            new Employee(6, "Ola", "Finance", 45, 14000),
            new Employee(7, "Tomek", "Finance", 26, 7500),
            new Employee(8, "Ewa", "IT", 38, 11000)
    );

    Map<String,Double> avgPayment = employees.stream()
            .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.averagingDouble(Employee::salary)
                    ));

    Map<String, Optional<Employee>> bestPayment = employees.stream()
            .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
            ));

        Map<String, String> workersOver30 = employees.stream()
                .filter(age -> age.age() > 30)
                .sorted(Comparator.comparing(Employee::name))
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(
                                Employee::name,
                                Collectors.joining(" | ")
                        )
                ));

       List<String> topThreeWorkers = employees.stream()
               .sorted(
                       Comparator.comparing(Employee::salary).reversed()
                               .thenComparing(Employee::age)
               )
               .map(Employee::name)
               .limit(3)
               .toList();

        System.out.println(topThreeWorkers);
    }
}
