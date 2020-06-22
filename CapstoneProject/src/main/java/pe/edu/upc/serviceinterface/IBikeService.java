package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Bike;

public interface IBikeService {
	public void insert(Bike bike);
	List<Bike> list();
	Optional<Bike>searchId(int idBike);
	public void update(Bike bike) ;
	public List<Bike> search(int busqueda);
}
