package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.RentalTicket;

public interface IRentalTicketService {

	public void insert(RentalTicket rentalticket);
	List<RentalTicket>list();
	
	public void delete(int idRentalTicket);
	
	public void update(RentalTicket rentalTicket);
	
	public List<RentalTicket> search(int busqueda);
	

	Optional<RentalTicket> searchId(int idRentalTicket);

}
