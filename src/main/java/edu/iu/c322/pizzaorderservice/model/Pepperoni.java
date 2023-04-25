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
    private boolean add;
    private double cost = 1.49;

    public int getPepperoniId() {
        return pepperoniId;
    }

    public void setPepperoniId(int pepperoniId) {
        this.pepperoniId = pepperoniId;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
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
        return getPepperoniId() == pepperoni.getPepperoniId() && isAdd() == pepperoni.isAdd() && Double.compare(pepperoni.getCost(), getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPepperoniId(), isAdd(), getCost());
    }
}
