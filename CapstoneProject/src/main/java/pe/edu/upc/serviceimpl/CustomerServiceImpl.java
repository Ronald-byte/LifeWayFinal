package pe.edu.upc.serviceimpl;

import java.util.List;

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
	public void insert(Customer customer) {
		cR.save(customer);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}