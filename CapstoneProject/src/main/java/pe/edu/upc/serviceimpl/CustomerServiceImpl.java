package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.repository.ICustomerRepository;
import pe.edu.upc.serviceinterface.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository cR;
	
	@Transactional
	@Override
	public int insert(Customer customer) {
		int rpta = cR.searchCustomer(customer.getNameCustomer());
		if (rpta == 0)
		{
			cR.save(customer);
		}
		return rpta;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public List<Customer> findNameCustumerFull(String nameCustomer) {
		// TODO Auto-generated method stub
		return cR.findBynameCustomer(nameCustomer);
	}

	public Optional<Customer> searchId(int idCustomer)
	{
		return cR.findById(idCustomer);
	}
}
