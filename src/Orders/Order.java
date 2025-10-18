package Orders;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private String customerName;
    private double amount;
    private String status;
    private LocalDate orderDate;

    public Order(String orderId, String customerName, double amount, String status, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    @Override
    public String toString() {
        return String.format("Order{id='%s', name='%s', amount=%.2f, status='%s', date=%s}",
                orderId, customerName, amount, status, orderDate);
    }
}