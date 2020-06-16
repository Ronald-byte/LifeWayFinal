package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select count(c.nameCustomer) from Customer c where UPPER(c.nameCustomer)=:nameCustomer or LOWER(c.nameCustomer)=:nameCustomer")
	public int searchCustomer(@Param("nameCustomer") String nombre);
	
	@Query("select c from Customer c where c.nameCustomer LIKE CONCAT('%',:nameCustomer,'%') OR UPPER(c.nameCustomer) LIKE CONCAT('%',nameCustomer,'%') or LOWER(c.nameCustomer) LIKE CONCAT('%',:nameCustomer,'%')")
	List<Customer> findBynameCustomer(String nameCustomer);
}
