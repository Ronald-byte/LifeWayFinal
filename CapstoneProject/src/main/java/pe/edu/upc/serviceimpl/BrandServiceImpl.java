package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.repository.IBrandRepository;
import pe.edu.upc.serviceinterface.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService{
	
	@Autowired
	private IBrandRepository bR;
	
	@Transactional
	@Override
	public void insert(Brand brand) {
		bR.save(brand);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}
	
	
	
}
