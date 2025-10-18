package Orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderMain {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("O001", "Айжан", 20000, "PAID", LocalDate.of(2025, 5, 20)));
        orders.add(new Order("O002", "Бекзат", 10000, "NEW", LocalDate.of(2025, 6, 1)));
        orders.add(new Order("O003", "Еркежан", 35000, "PAID", LocalDate.of(2025, 4, 28)));
        orders.add(new Order("O004", "Тимур", 5000, "CANCELLED", LocalDate.of(2025, 7, 10)));

        OrderService service = new OrderServiceImpl();

        System.out.println("1️⃣ Заказы по диапазону суммы (8 000 - 25 000):");
        service.findOrdersByAmountRange(orders, 8000, 25000).forEach(System.out::println);

        System.out.println("\n2️⃣ Заказы со статусом PAID:");
        service.findOrdersByStatus(orders, "PAID").forEach(System.out::println);

        System.out.println("\n3️⃣ Заказы с суммой выше средней:");
        service.findHighValueOrders(orders).forEach(System.out::println);
    }
}