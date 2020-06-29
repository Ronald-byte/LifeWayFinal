package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Bike;
import pe.edu.upc.repository.IBikeRepository;
import pe.edu.upc.serviceinterface.IBikeService;

@Service
public class BikeServiceImpl implements IBikeService {

	@Autowired
	private IBikeRepository bR;

	@Override
	public List<Bike> list() {
		return bR.findAll();
	}

	@Transactional
	@Override
	public void insert(Bike bike) {
		bR.save(bike);
	}

	@Transactional
	@Override
	public Optional<Bike> searchId(int idBike) {
		return bR.findById(idBike);
	}

	@Transactional
	@Override
	public void update(Bike bike) {
		bR.save(bike);
	}

	@Override
	public List<Bike> search(int busqueda) {
		return bR.search(busqueda);
	}

	@Override
	public List<String[]> bikeTop() {
		return bR.bikeTop();
	}
}
