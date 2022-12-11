package Enoca.demo.business.abstracts;

import java.util.List;

import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;

public interface OrderService {

	void add(CreateOrderRequest createOrderRequest) throws Exception;

	void delete(DeleteOrderRequest deleteOrderRequest) throws Exception;

	void update(UpdateOrderRequest updateOrderRequest) throws Exception;

	List<GetAllOrderResponse> getAll();

	GetOrderByIdResponse getOrderByIdResponse(int id) throws Exception;
	

	
}
