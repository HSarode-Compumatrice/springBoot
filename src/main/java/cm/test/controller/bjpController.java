package cm.test.controller;

import cm.test.exception.ResourceNotFoundException;
import cm.test.model.Orders;
import cm.test.model.bjpTest;
import cm.test.repository.OrdersRepository;
import cm.test.repository.bjpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/bjp")
public class bjpController {

    @Autowired
    bjpRepository bjpRepository;

    @GetMapping("/popup")
    public List<bjpTest> getAllOrders() {
        return bjpRepository.findAll();
    }

    @PostMapping("/popup")
    public bjpTest createOrder(@Valid @RequestBody bjpTest bjp) {
    	bjp.setDate(new Date());
    	//bjp = bjpRepository.save(bjp);
        return bjpRepository.save(bjp);
    }

 

	@GetMapping("/popup/{id}")
    public bjpTest getpopById(@PathVariable(value = "id") Integer id) {
        return bjpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("bjpTest", "id", id));
    }

  /*  @PutMapping("/popup/{id}")
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
    }*/
}
