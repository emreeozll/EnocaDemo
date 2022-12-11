package Enoca.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Enoca.demo.business.abstracts.CustomerService;
import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;
import Enoca.demo.dataAccess.abstracts.CustomerRepository;
import Enoca.demo.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerManager(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;
	}

	private boolean isValidCustomer(String name, int age) throws Exception {

		if (name.isEmpty()) {

			throw new Exception("The name field is required.");
		}

		if (age < 18) {

			throw new Exception("The age limit is 18.");
		}

		return true;
	}

	private boolean isValidCustomerId(int id) throws Exception {

		if (!customerRepository.existsById(id)) {

			throw new Exception("No registered user found.");
		}

		return true;
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) throws Exception {

		isValidCustomer(createCustomerRequest.getName(), createCustomerRequest.getAge());

		Customer customer = new Customer();
		customer.setName(createCustomerRequest.getName());
		customer.setAge(createCustomerRequest.getAge());

		customerRepository.save(customer);

	}

	@Override
	public void delete(DeleteCustomerRequest deleteCustomerRequest) throws Exception {

		isValidCustomerId(deleteCustomerRequest.getId());

		Customer customer = customerRepository.getReferenceById(deleteCustomerRequest.getId());
		customerRepository.delete(customer);

	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) throws Exception {

		isValidCustomerId(updateCustomerRequest.getId());
		isValidCustomer(updateCustomerRequest.getName(), updateCustomerRequest.getAge());

		Customer customer = customerRepository.getReferenceById(updateCustomerRequest.getId());
		customer.setName(updateCustomerRequest.getName());
		customer.setAge(updateCustomerRequest.getAge());

		customerRepository.save(customer);

	}

	@Override
	public List<GetAllCustomerReponse> getAll() {

		List<Customer> customers = customerRepository.findAll();
		List<GetAllCustomerReponse> allCustomerReponses = new ArrayList<GetAllCustomerReponse>();

		for (Customer customer : customers) {

			GetAllCustomerReponse getCustomerReponse = new GetAllCustomerReponse();
			getCustomerReponse.setId(customer.getId());
			getCustomerReponse.setName(customer.getName());
			getCustomerReponse.setAge(customer.getAge());

			allCustomerReponses.add(getCustomerReponse);

		}

		return allCustomerReponses;

	}

	@Override
	public GetCustomerByIdResponse getCustomerByIdResponse(int id) throws Exception {

		isValidCustomerId(id);

		Customer customer = customerRepository.getReferenceById(id);
		GetCustomerByIdResponse byIdResponse = new GetCustomerByIdResponse();
		byIdResponse.setId(customer.getId());
		byIdResponse.setName(customer.getName());
		byIdResponse.setAge(customer.getAge());

		return byIdResponse;
	}

}
