package Enoca.demo.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Enoca.demo.business.abstracts.CustomerService;
import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomersController  {

	private CustomerService customerService;

	public CustomersController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	
	@PostMapping("/add")
	public void add(CreateCustomerRequest createCustomerRequest) throws Exception {
		
		customerService.add(createCustomerRequest);
	}
	
	@DeleteMapping("/delete")
	public void add(DeleteCustomerRequest deleteCustomerRequest) throws Exception {
		
		customerService.delete(deleteCustomerRequest);
	}
	
	@PutMapping("/update")
	public void add(UpdateCustomerRequest updateCustomerRequest) throws Exception {
		
		customerService.update(updateCustomerRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllCustomerReponse> getAll(){  
		
		return customerService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetCustomerByIdResponse getByIdResponse(int id) throws Exception {
		
		return customerService.getCustomerByIdResponse(id);
	}
	
	
	
	
	
}
