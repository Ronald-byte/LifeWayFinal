package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypeEmployee;

public interface ITypeEmployeeService {
	public void insert(TypeEmployee typeEmployee);

	List<TypeEmployee> list();
}
