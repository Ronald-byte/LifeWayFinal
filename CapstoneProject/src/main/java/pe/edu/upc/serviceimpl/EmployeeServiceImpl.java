package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Employee;
import pe.edu.upc.repository.IEmployeeRepository;
import pe.edu.upc.serviceinterface.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository eR;

	@Transactional
	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		eR.save(employee);
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return eR.findAll();
	}

}
