package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Pepperoni pepperoni;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Sausage sausage;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private ExtraCheese extraCheese;
    private int quantity;
    private double totalCost;
    private boolean returned;
    private String reason;
    private String trackingStatus;
    private String date;

    public Pepperoni getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(Pepperoni pepperoni) {
        this.pepperoni = pepperoni;
    }

    public Sausage getSausage() {
        return sausage;
    }

    public void setSausage(Sausage sausage) {
        this.sausage = sausage;
    }

    public ExtraCheese getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(ExtraCheese extraCheese) {
        this.extraCheese = extraCheese;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        if (extraCheese.isAdd()) {
            totalCost = quantity * (pepperoni.getQuantity() * pepperoni.getCost()) + (sausage.getQuantity() * sausage.getCost()) + (extraCheese.getCost());
        }
        else {
            totalCost = quantity * (pepperoni.getQuantity() * pepperoni.getCost()) + (sausage.getQuantity() * sausage.getCost());
        }
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTrackingStatus() {
        return trackingStatus;
    }

    public void setTrackingStatus(String trackingStatus) {
        this.trackingStatus = trackingStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return getItemId() == item.getItemId() && getQuantity() == item.getQuantity() && Double.compare(item.getTotalCost(), getTotalCost()) == 0 && isReturned() == item.isReturned() && Objects.equals(getPepperoni(), item.getPepperoni()) && Objects.equals(getSausage(), item.getSausage()) && Objects.equals(getExtraCheese(), item.getExtraCheese()) && Objects.equals(getReason(), item.getReason()) && Objects.equals(getTrackingStatus(), item.getTrackingStatus()) && Objects.equals(getDate(), item.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getPepperoni(), getSausage(), getExtraCheese(), getQuantity(), getTotalCost(), isReturned(), getReason(), getTrackingStatus(), getDate());
    }
}
