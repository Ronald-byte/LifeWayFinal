package pe.edu.upc.serviceinterfce;

import java.util.List;

import pe.edu.upc.entity.TypeEmployee;

public interface ITypeEmployeeService {
	public void insert(TypeEmployee typeEmployee);

	List<TypeEmployee> list();
}
