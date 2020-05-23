package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.RentalTicket;

@Repository
public interface IRentalTicketRepository extends JpaRepository<RentalTicket, Integer>{

}
