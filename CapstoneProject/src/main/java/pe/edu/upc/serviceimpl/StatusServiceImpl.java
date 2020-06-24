package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Status;
import pe.edu.upc.repository.IStatusRepository;
import pe.edu.upc.serviceinterface.IStatusService;

@Service
public class StatusServiceImpl implements IStatusService{
	
	@Autowired
	private IStatusRepository sR;

	@Transactional
	@Override
	public int insert(Status status) {
		// TODO Auto-generated method stub
		int rpta=sR.searchStatus(status.getNameStatus());
		if(rpta==0)
		{
			sR.save(status);
		}
		return rpta;
		
	}

	@Override
	public List<Status> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

	@Transactional
	@Override
	public Optional<Status> searchId(int idStatus) {
		return sR.findById(idStatus);
	}

}
