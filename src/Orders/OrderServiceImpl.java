package Orders;

import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> findOrdersByAmountRange(List<Order> orders, double minAmount, double maxAmount) {
        if (orders == null) return Collections.emptyList();

        return orders.stream()
                .filter(o -> o != null && o.getAmount() >= minAmount && o.getAmount() <= maxAmount)
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByStatus(List<Order> orders, String status) {
        if (orders == null || status == null) return Collections.emptyList();

        return orders.stream()
                .filter(o -> o != null && status.equalsIgnoreCase(o.getStatus()))
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findHighValueOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) return Collections.emptyList();

        double avg = orders.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Order::getAmount)
                .average()
                .orElse(0);

        return orders.stream()
                .filter(o -> o != null && o.getAmount() > avg)
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .collect(Collectors.toList());
    }
}