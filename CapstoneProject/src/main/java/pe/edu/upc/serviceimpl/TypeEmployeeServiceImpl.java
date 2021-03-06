package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeEmployee;
import pe.edu.upc.repository.ITypeEmployeeRepository;
import pe.edu.upc.serviceinterface.ITypeEmployeeService;

@Service
public class TypeEmployeeServiceImpl implements ITypeEmployeeService {

	@Autowired
	private ITypeEmployeeRepository teR;

	@Transactional
	@Override
	public int insert(TypeEmployee typeEmployee) {
		// TODO Auto-generated method stub
		int rpta=teR.seachTypeEmployee(typeEmployee.getNameTypeEmployee());
		if(rpta==0)
		{
			teR.save(typeEmployee);
		}
		return rpta;
	}

	@Override
	public List<TypeEmployee> list() {
		// TODO Auto-generated method stub
		return teR.findAll();
	}

	@Transactional
	@Override
	public Optional<TypeEmployee> searchId(int idTypeEmployee) {
		// TODO Auto-generated method stub
		return teR.findById(idTypeEmployee);
	}

	@Override
	public List<TypeEmployee> findByNameTypeEmployeeFull(String nameTypeEmployee) {
		// TODO Auto-generated method stub
		return teR.findBynameTypeEmployee(nameTypeEmployee);
	}

	@Override
	public List<String[]> typetop() {
		// TODO Auto-generated method stub
		return teR.typeTop();
	}

	

}
