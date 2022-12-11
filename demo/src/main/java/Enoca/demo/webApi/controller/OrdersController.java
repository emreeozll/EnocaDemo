package Enoca.demo.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Enoca.demo.business.abstracts.OrderService;
import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	public OrdersController(OrderService orderService) {
		
		this.orderService = orderService;
	}
	
	@PostMapping("/add")
	public void add(CreateOrderRequest createOrderRequest) throws Exception {
		
		orderService.add(createOrderRequest);
	}
	
	@DeleteMapping("/delete")
	public void add(DeleteOrderRequest deleteOrderRequest) throws Exception {
		
		orderService.delete(deleteOrderRequest);
	}
	
	@PutMapping("/update")
	public void add(UpdateOrderRequest updateOrderRequest) throws Exception {
		
		orderService.update(updateOrderRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllOrderResponse> getAll(){  
		
		return orderService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetOrderByIdResponse getOrderByIdResponse (int id) throws Exception {
		
		return orderService.getOrderByIdResponse(id);
	}
	

	
	
	
}
