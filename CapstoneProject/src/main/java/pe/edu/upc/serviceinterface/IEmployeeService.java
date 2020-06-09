package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Employee;

public interface IEmployeeService {
	
	public int insert(Employee employee);
	
	List<Employee> list();
	
	public void delete(int idEmployee);

	Optional<Employee> searchId(int idEmployee);
}
