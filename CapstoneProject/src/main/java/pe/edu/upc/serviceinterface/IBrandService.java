package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	
	public int insert(Brand brand);
	List<Brand>list();
	Optional<Brand>searchId(int idBrand);
	public List<String[]> brandtop();
}
