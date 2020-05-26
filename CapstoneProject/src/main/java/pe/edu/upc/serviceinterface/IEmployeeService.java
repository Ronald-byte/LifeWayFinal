package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Employee;

public interface IEmployeeService {
	
	public void insert(Employee employee);
	
	List<Employee> list();

}
