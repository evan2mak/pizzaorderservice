package edu.iu.c322.pizzaorderservice.repository;

import edu.iu.c322.pizzaorderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
    List<Orders> findByCustomerId(int customerId);
}
