package cm.test.controller;

import cm.test.exception.ResourceNotFoundException;
import cm.test.model.Orders;
import cm.test.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping("/orders")
    public Orders createOrder(@Valid @RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @GetMapping("/orders/{id}")
    public Orders getOrderById(@PathVariable(value = "id") Integer OrderId) {
        return ordersRepository.findById(OrderId)
                .orElseThrow(() -> new ResourceNotFoundException("Orders", "id", OrderId));
    }

    @PutMapping("/orders/{id}")
    public Orders updateOrders(@PathVariable(value = "id") Integer OrderId,
                                           @Valid @RequestBody Orders orderDetails) {

    	Orders orders = ordersRepository.findById(OrderId)
                .orElseThrow(() -> new ResourceNotFoundException("Orders", "id", OrderId));

    	
    	orders.setCustId(orderDetails.getCustId());
    	orders.setProdId(orderDetails.getProdId());
    	orders.setQty(orderDetails.getQty());
    	orders.setRate(orderDetails.getRate());
    	orders.setReturnDate(orderDetails.getReturnDate());

        Orders updatedOrders = ordersRepository.save(orders);
        return updatedOrders;
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Integer OrderId) {
        Orders orders = ordersRepository.findById(OrderId)
                .orElseThrow(() -> new ResourceNotFoundException("Orders", "id", OrderId));

        ordersRepository.delete(orders);

        return ResponseEntity.ok().build();
    }
}
