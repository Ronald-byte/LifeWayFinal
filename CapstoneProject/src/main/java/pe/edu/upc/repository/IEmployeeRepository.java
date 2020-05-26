package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	

}
