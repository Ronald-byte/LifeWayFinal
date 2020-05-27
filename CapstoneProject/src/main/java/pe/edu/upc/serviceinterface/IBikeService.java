package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Bike;

public interface IBikeService {

	public void insert(Bike bike);
	 
	List<Bike> list();
	
	
}
