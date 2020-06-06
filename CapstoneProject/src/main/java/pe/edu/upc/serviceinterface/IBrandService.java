package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	
	public void insert(Brand brand);
	List<Brand>list();
	Optional<Brand>searchId(int idBrand);
}
