package Enoca.demo.business.abstracts;

import java.util.List;

import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;

public interface CustomerService {

	
	void add(CreateCustomerRequest createCustomerRequest) throws Exception;
	
	void delete(DeleteCustomerRequest deleteCustomerRequest) throws Exception;
	
	void update(UpdateCustomerRequest updateCustomerRequest)throws Exception;
	
	List<GetAllCustomerReponse> getAll();
	
	GetCustomerByIdResponse getCustomerByIdResponse(int id) throws Exception;
}
