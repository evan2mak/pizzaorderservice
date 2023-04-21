package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ExtraCheese {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int extraCheeseId;
    private boolean add;
    private double cost = .99;

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
        if (!(o instanceof ExtraCheese that)) return false;
        return isAdd() == that.isAdd();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAdd());
    }
}
