package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Employee;

public interface IEmployeeService {
	
	public int insert(Employee employee);
	
	List<Employee> list();

}
