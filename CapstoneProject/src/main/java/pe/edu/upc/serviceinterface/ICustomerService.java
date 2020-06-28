package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Customer;

public interface ICustomerService {
	public int insert(Customer customer);
	public void update(Customer customer);
	List<Customer> list();
	List<Customer> findNameCustumerFull(int idCustomer);
	Optional<Customer> searchId(int idCustomer);
	public List<String[]> customertop();
}
