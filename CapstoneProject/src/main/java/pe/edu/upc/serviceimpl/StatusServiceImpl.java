package pe.edu.upc.serviceimpl;

import java.util.List;

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
	public void insert(Status status) {
		sR.save(status);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Status> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

}
