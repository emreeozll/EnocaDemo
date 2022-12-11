package Enoca.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Enoca.demo.business.abstracts.OrderService;
import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;
import Enoca.demo.dataAccess.abstracts.CustomerRepository;
import Enoca.demo.dataAccess.abstracts.OrderRepository;
import Enoca.demo.entities.concretes.Customer;
import Enoca.demo.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

	private OrderRepository orderRepository;

	private CustomerRepository customerRepository;

	@Autowired
	public OrderManager(OrderRepository orderRepository, CustomerRepository customerRepository) {

		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}

	private boolean isValidOrder(String createDate, double totalPrice, int customer_Id) throws Exception {

		if (createDate.isEmpty()) {

			throw new Exception("Error: The createdate field is required !");
		}

		if (totalPrice <= 0) {

			throw new Exception("Error: Total Price please enter a valid amount !");
		}


		return true;
	}

	private boolean isValidOrderId(int id) throws Exception {

		if (!orderRepository.existsById(id)) {

			throw new Exception("Error: No registered order found !");
		}

		return true;
	}

	@Override
	public void add(CreateOrderRequest createOrderRequest) throws Exception {

		isValidOrder(createOrderRequest.getCreateDate(), createOrderRequest.getTotalPrice(),createOrderRequest.getCustomer_Id());
		
		Order order = new Order();
		order.setTotalPrice(createOrderRequest.getTotalPrice());
		order.setCreateDate(createOrderRequest.getCreateDate());

		Customer customer = customerRepository.findById(createOrderRequest.getCustomer_Id()).orElseThrow();
		order.setCustomer(customer);
		orderRepository.save(order);

	}

	@Override
	public void delete(DeleteOrderRequest deleteOrderRequest) throws Exception {

		isValidOrderId(deleteOrderRequest.getId());

		Order order = orderRepository.findById(deleteOrderRequest.getId()).orElseThrow();
		orderRepository.deleteById(deleteOrderRequest.getId());

	}

	@Override
	public void update(UpdateOrderRequest updateOrderRequest) throws Exception {

		isValidOrder(updateOrderRequest.getCreateDate(), updateOrderRequest.getTotalPrice(),updateOrderRequest.getCustomer_Id());
		isValidOrderId(updateOrderRequest.getId());

		Order order = orderRepository.getReferenceById(updateOrderRequest.getCustomer_Id());
		order.setCreateDate(updateOrderRequest.getCreateDate());
		order.setTotalPrice(updateOrderRequest.getTotalPrice());

		Customer customer = customerRepository.getReferenceById(updateOrderRequest.getCustomer_Id());

		order.setCustomer(customer);

		orderRepository.save(order);

	}

	@Override
	public List<GetAllOrderResponse> getAll() {

		List<Order> orders = orderRepository.findAll();
		List<GetAllOrderResponse> allOrderResponses = new ArrayList<GetAllOrderResponse>();

		for (Order order : orders) {

			GetAllOrderResponse allOrderResponse = new GetAllOrderResponse();
			allOrderResponse.setId(order.getId());
			allOrderResponse.setCreateDate(order.getCreateDate());
			allOrderResponse.setTotalPrice(order.getTotalPrice());
			allOrderResponse.setCustomer_Id(order.getCustomer().getId());
			
			allOrderResponses.add(allOrderResponse);

		}

		return allOrderResponses;
	}

	@Override
	public GetOrderByIdResponse getOrderByIdResponse(int id) throws Exception {

		Order order = orderRepository.findById(id).orElseThrow();
		GetOrderByIdResponse orderByIdResponse = new GetOrderByIdResponse();
		orderByIdResponse.setId(order.getId());
		orderByIdResponse.setCreateDate(order.getCreateDate());
		orderByIdResponse.setTotalPrice(order.getTotalPrice());
		orderByIdResponse.setCustomer_Id(order.getCustomer().getId());

		return orderByIdResponse;
	}
	
	
		


		
		
		
	

}
