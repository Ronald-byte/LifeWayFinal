package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.RentalTicket;
import pe.edu.upc.repository.IRentalTicketRepository;
import pe.edu.upc.serviceinterface.IRentalTicketService;

@Service
public class RentalTicketServiceImpl implements IRentalTicketService{

	@Autowired
	private IRentalTicketRepository rTR;
	
	
	@Transactional
	@Override
	public void insert(RentalTicket rentalticket) {
		rTR.save(rentalticket);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RentalTicket> list() {
		// TODO Auto-generated method stub
		return rTR.findAll();
	}
	
	@Transactional
	@Override
	public void delete(int idRentalTicket) {
		rTR.deleteById(idRentalTicket);
	}

	@Override
	public List<RentalTicket> search(int busqueda) {
		// TODO Auto-generated method stub
		return rTR.search(busqueda);
	}
	
	@Override
	public Optional<RentalTicket> searchId(int idRentalTicket) {
		// TODO Auto-generated method stub
		return rTR.findById(idRentalTicket);
	}

	
	@Transactional
	@Override
	public void update(RentalTicket rentalTicket) {
		// TODO Auto-generated method stub
		rTR.save(rentalTicket);
	}
	
}
