package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
    


}
