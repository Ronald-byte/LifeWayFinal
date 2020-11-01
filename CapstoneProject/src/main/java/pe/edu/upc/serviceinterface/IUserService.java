package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Users;

public interface IUserService {
	public int insert(Users users);

	List<Users> list();
}
