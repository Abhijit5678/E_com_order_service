package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entiy.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query(nativeQuery = true,value = "SELECT * FROM order_tb where productid=?1")
	List<Order> getOrderListByProductId(int productId);
	@Query(nativeQuery = true, value = "SELECT * FROM order_tb where orderid=?1")
	Order getOrderByIde(int orderId);

}
