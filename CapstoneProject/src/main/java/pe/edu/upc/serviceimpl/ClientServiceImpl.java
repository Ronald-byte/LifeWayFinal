package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.IClienteRepository;
import pe.edu.upc.serviceinterfce.IClienteService;

@Service
public class ClientServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepository cR;
	
	@Transactional
	@Override
	public void insert(Cliente cliente) {
		cR.save(cliente);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
