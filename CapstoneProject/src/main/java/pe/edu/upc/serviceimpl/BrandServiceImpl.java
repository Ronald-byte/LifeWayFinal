package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	public int insert(Brand brand) {
		// TODO Auto-generated method stub
		int rpta=bR.searchBrand(brand.getNameBrand());
		if(rpta==0)
		{
			bR.save(brand);
		}
		return rpta;
		
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

	@Transactional
	@Override
	public Optional<Brand> searchId(int idBrand) {
		return bR.findById(idBrand);
	}

	@Override
	public List<String[]> brandtop() {
		// TODO Auto-generated method stub
		return bR.brandTop();
	}
	
	
	
}
