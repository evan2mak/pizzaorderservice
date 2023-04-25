package edu.iu.c322.pizzaorderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Sausage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sausageId;
    private boolean add;
    private double cost = 1.49;

    public int getSausageId() {
        return sausageId;
    }

    public void setSausageId(int sausageId) {
        this.sausageId = sausageId;
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
        if (!(o instanceof Sausage sausage)) return false;
        return getSausageId() == sausage.getSausageId() && isAdd() == sausage.isAdd() && Double.compare(sausage.getCost(), getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSausageId(), isAdd(), getCost());
    }
}
