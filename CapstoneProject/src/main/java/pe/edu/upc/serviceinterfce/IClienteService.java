package pe.edu.upc.serviceinterfce;

import java.util.List;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {
	public void insert(Cliente cliente);
	List<Cliente> list();

}
