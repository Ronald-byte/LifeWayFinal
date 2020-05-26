package pe.edu.upc.serviceinterfce;

import java.util.List;

import pe.edu.upc.entity.Customer;

public interface ICustomerService {
	public void insert(Customer customer);
	List<Customer> list();

}
