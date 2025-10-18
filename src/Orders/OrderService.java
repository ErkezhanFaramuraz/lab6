package Orders;

import java.util.List;

public interface OrderService {
    List<Order> findOrdersByAmountRange(List<Order> orders, double minAmount, double maxAmount);
    List<Order> findOrdersByStatus(List<Order> orders, String status);
    List<Order> findHighValueOrders(List<Order> orders);
}