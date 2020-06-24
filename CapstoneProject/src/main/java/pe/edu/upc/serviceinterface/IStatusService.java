package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Status;

public interface IStatusService {

	public int insert(Status status);
	List<Status>list();
	Optional<Status>searchId(int idStatus);
}
