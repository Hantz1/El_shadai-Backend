package com.teklik.backend_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teklik.backend_security.exception.ResourceNotFoundException;
import com.teklik.backend_security.model.Order;
import com.teklik.backend_security.repository.OrderRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable  long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not exist with id:" + id));
        return ResponseEntity.ok(order);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable long id,@RequestBody Order orderParams) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not exist with id:" + id));

                order.setProducts(orderParams.getProducts());
                order.setAmount(orderParams.getAmount());
                order.setTotalsale(orderParams.getTotalsale());
                order.setSalesperson(orderParams.getSalesperson());
                order.setCustomer(orderParams.getCustomer());
                order.setStatus(orderParams.getStatus());
                order.setDatesale(orderParams.getDatesale());

        orderRepository.save(order);

        return ResponseEntity.ok(order);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable long id){

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not exist with id: " + id));

        orderRepository.delete(order);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}