package pe.edu.upc.serviceinterfce;

import java.util.List;

import pe.edu.upc.entity.Status;

public interface IStatusService {

	public void insert(Status status);
	List<Status>list();
}
