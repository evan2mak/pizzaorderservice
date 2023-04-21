package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

@Entity
public class PizzaOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int customerId;
    @ManyToOne(cascade = CascadeType.ALL)
    @Valid
    private ShippingAddress shippingAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.ALL)
    @Valid
    private Payment payment;
    private String cancelOrder;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getCancelOrder() {
        return cancelOrder;
    }

    public void setCancelOrder(String cancelOrder) {
        this.cancelOrder = cancelOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrders pizzaOrders)) return false;
        return getOrderId() == pizzaOrders.getOrderId() && getCustomerId() == pizzaOrders.getCustomerId() && Objects.equals(getShippingAddress(), pizzaOrders.getShippingAddress()) && Objects.equals(getItems(), pizzaOrders.getItems()) && Objects.equals(getPayment(), pizzaOrders.getPayment()) && Objects.equals(getCancelOrder(), pizzaOrders.getCancelOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getCustomerId(), getShippingAddress(), getItems(), getPayment(), getCancelOrder());
    }
}
