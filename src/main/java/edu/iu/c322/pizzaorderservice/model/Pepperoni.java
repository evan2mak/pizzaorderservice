package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Pepperoni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pepperoniId;
    private int quantity;
    private double cost = 1.49;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pepperoni pepperoni)) return false;
        return getQuantity() == pepperoni.getQuantity() && Double.compare(pepperoni.getCost(), getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(), getCost());
    }
}
