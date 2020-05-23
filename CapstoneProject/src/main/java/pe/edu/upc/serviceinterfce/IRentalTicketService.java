package pe.edu.upc.serviceinterfce;

import java.util.List;

import pe.edu.upc.entity.RentalTicket;

public interface IRentalTicketService {

	public void insert(RentalTicket rentalticket);
	List<RentalTicket>list();
}
