package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Customer;

public interface ICustomerService {
	public int insert(Customer customer);
	List<Customer> list();
	List<Customer> findNameCustumerFull(String nameCustomer);
	Optional<Customer> searchId(int idCustomer);
}
