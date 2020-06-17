package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.RentalTicket;

@Repository
public interface IRentalTicketRepository extends JpaRepository<RentalTicket, Integer>{

	
	@Query("from RentalTicket r where r.customer.nameCustomer like %:busqueda%")
	List<RentalTicket> search(@Param("busqueda") String busqueda);
	
}
