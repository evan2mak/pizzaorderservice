package edu.iu.c322.pizzaorderservice.controller;

import java.util.List;
import java.util.Optional;

import edu.iu.c322.pizzaorderservice.model.*;
import edu.iu.c322.pizzaorderservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "https://pizzaservice-frontend.vercel.app/")
public class OrderController {
    // Implement decorator pattern somewhere

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{customerId}")
    public List<PizzaOrders> findByCustomerId(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody PizzaOrders order) {
        PizzaOrders addedOrder = repository.save(order);
        return addedOrder.getOrderId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/return")
    public void update(@Valid @RequestBody UpdateRequest request) {
        Optional<PizzaOrders> optionalOrder = repository.findById(request.getOrderId());
        if (optionalOrder.isPresent()) {
            PizzaOrders order = optionalOrder.get();
            for (Item item : order.getItems()) {
                item.setReturned(true);
                item.setReason(request.getReason());
            }
            repository.save(order);
        }
        else {
            throw new IllegalStateException("Order ID is not valid.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{orderId}")
    public void delete(@Valid @RequestBody DeleteRequest request) {
        Optional<PizzaOrders> optionalOrder = repository.findById(request.getOrderId());
        if (optionalOrder.isPresent()) {
            PizzaOrders order = optionalOrder.get();
            order.setCancelOrder(request.getCancelOrder());
            repository.save(order);
        }
        else {
            throw new IllegalStateException("Order ID is not valid.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable int orderId) {
        repository.deleteById(orderId);
    }
}
