package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("select count(e.nameEmployee) from Employee e where e.nameEmployee=UPPER(:nameEmployee)")
	public int seachProduct(@Param("nameEmployee") String nombre);

}
