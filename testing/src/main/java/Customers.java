import java.util.List;

record Order(
        int id,
        String customer,
        String status,
        List<String> products,
        double total
) {}




