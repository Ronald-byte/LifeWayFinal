package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeEmployee;
import pe.edu.upc.repository.ITypeEmployeeRepository;
import pe.edu.upc.serviceinterfce.ITypeEmployeeService;

@Service
public class TypeEmployeeServiceImpl implements ITypeEmployeeService {

	@Autowired
	private ITypeEmployeeRepository teR;

	@Transactional
	@Override
	public void insert(TypeEmployee typeEmployee) {
		// TODO Auto-generated method stub
		teR.save(typeEmployee);
	}

	@Override
	public List<TypeEmployee> list() {
		// TODO Auto-generated method stub
		return teR.findAll();
	}

}
