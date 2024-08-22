package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entiy.Order;
import com.example.demo.Service.OrderService;
import com.example.demo.Utils.Response;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Response<?>> createOrder(@RequestBody Order order)
	{
		Response<?> response=new Response<Object>();
		Order ord=new Order();
		
		ord=orderservice.saveOrder(order);
		response.setData(ord);
		
		return ResponseEntity.ok(response);
	
		
		
	}
	
	@GetMapping("/getOrderListByProduct/{productId}")
	public ResponseEntity<Response<?>> getOrderListByProductId(@PathVariable int productId)
	{
		Response<?> response =new Response<>();
		
		List<Order> listOrder =orderservice.getOrderListByProductId(productId);
		response.setData(listOrder);
		
		
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
	
}
