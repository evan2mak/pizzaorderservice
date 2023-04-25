package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.text.DecimalFormat;
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
    private int baseCostPlainPizza = 10;
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
        if (pepperoni.isAdd() && sausage.isAdd() && extraCheese.isAdd()){
            totalCost = (baseCostPlainPizza + (pepperoni.getCost() + sausage.getCost() + extraCheese.getCost())) * quantity;
        }
        else if (pepperoni.isAdd() && sausage.isAdd()){
            totalCost = (baseCostPlainPizza + (pepperoni.getCost() + sausage.getCost())) * quantity;
        }
        else if (pepperoni.isAdd() && extraCheese.isAdd()){
            totalCost = (baseCostPlainPizza + (pepperoni.getCost() + extraCheese.getCost())) * quantity;
        }
        else if (sausage.isAdd() && extraCheese.isAdd()){
            totalCost = (baseCostPlainPizza + (sausage.getCost() + extraCheese.getCost())) * quantity;
        }
        else if(pepperoni.isAdd()){
            totalCost = (baseCostPlainPizza + pepperoni.getCost()) * quantity;
        }
        else if(sausage.isAdd()){
            totalCost = (baseCostPlainPizza + sausage.getCost()) * quantity;
        }
        else if(extraCheese.isAdd()){
            totalCost = (baseCostPlainPizza + extraCheese.getCost()) * quantity;
        }
        else {
            totalCost = baseCostPlainPizza * quantity;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(totalCost));
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
