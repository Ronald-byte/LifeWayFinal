package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		int rpta=eR.seachDni(employee.getDniEmployee());
		if (rpta==0) {
			eR.save(employee);
		}
		return rpta;
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return eR.findAll();
	}

	@Transactional
	@Override
	public void delete(int idEmployee) {
		// TODO Auto-generated method stub
		eR.deleteById(idEmployee);
	}

	@Override
	public Optional<Employee> searchId(int idEmployee) {
		// TODO Auto-generated method stub
		return eR.findById(idEmployee);
	}
	

	
}
