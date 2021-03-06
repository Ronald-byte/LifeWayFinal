package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.TypeEmployee;

@Repository
public interface ITypeEmployeeRepository extends JpaRepository<TypeEmployee, Integer> {
	@Query("select count(c.nameTypeEmployee) from TypeEmployee c where c.nameTypeEmployee=UPPER(:nameTypeEmployee) or c.nameTypeEmployee=LOWER(:nameTypeEmployee) or c.nameTypeEmployee=:nameTypeEmployee")
	public int seachTypeEmployee(@Param("nameTypeEmployee") String nombre);
	
	@Query("select c from TypeEmployee c where c.nameTypeEmployee LIKE CONCAT('%',:nameTypeEmployee,'%') OR UPPER(c.nameTypeEmployee) LIKE CONCAT('%',nameTypeEmployee,'%') or LOWER(c.nameTypeEmployee) LIKE CONCAT('%',:nameTypeEmployee,'%')")
	List<TypeEmployee> findBynameTypeEmployee(@Param("nameTypeEmployee") String nameType);
	
	@Query(value = "select e.name_employee,count(rt.id_rental_ticket) from employees e join rental_tickets rt on e.id_employee=rt.id_employee GROUP BY e.name_employee ORDER BY COUNT(rt.id_rental_ticket)DESC",nativeQuery = true)
    public List<String[]> typeTop();


}
