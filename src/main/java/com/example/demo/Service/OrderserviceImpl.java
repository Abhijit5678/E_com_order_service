package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entiy.Order;
import com.example.demo.Repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderserviceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderrepo;

	@Override
	public Order saveOrder(Order order) {
		
		return orderrepo.save(order);
	}

	@Override
	public List<Order> getOrderListByProductId(int productId) {
		
		return orderrepo.getOrderListByProductId(productId);
	}

	@Override
	@CircuitBreaker(name = "order-services", fallbackMethod = "productFallback")
	public Order getorderdetailsById(int orderId) {
		
		return orderrepo.getOrderByIde(orderId);
	}
	 
	public String productFallback(Long id, Throwable throwable) {
	        return "Fallback: Product Service is unavailable.";
	    }

}
