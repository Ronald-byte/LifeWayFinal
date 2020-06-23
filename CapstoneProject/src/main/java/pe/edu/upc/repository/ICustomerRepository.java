package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select count(c.idCustomer) from Customer c where c.idCustomer=:idCustomer")
	public int searchCustomer(@Param("idCustomer") int idCustomer);
	
	@Query("select c from Customer c where c.idCustomer = :busqueda")
	List<Customer> findBynameCustomer(@Param("busqueda")int idCustomer);
}


