package edu.iu.c322.pizzaorderservice.model;
public class UpdateRequest {
    private int orderId;
    private String reason;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
