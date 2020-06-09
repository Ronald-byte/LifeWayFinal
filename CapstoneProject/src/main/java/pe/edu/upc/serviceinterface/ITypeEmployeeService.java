package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TypeEmployee;

public interface ITypeEmployeeService {
	public int insert(TypeEmployee typeEmployee);

	List<TypeEmployee> list();
	
	Optional<TypeEmployee> searchId(int idTypeEmployee);
}
