package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
