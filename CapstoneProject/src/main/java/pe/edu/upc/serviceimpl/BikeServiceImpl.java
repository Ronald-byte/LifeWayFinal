package pe.edu.upc.serviceimpl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return bR.findAll();
	}
	
	@Transactional
	@Override
	public void insert(Bike bike) {
		// TODO Auto-generated method stub
		bR.save(bike);	
	}


	
}
