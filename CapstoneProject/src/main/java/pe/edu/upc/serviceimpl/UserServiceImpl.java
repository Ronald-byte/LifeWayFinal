package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Users;
import pe.edu.upc.repository.UserRepository;
import pe.edu.upc.serviceinterface.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository uR;

	@Override
	public int insert(Users users) {
		int rpta=uR.seachusername(users.getUsername());
		if(rpta==0) {
			uR.save(users);
		}
		return rpta;
	}

	@Override
	public List<Users> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}
}
