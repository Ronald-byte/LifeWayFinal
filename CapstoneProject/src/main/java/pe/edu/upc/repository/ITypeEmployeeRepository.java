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
	
	@Query(value = "select te.name_type_employee,count(e.id_employee) from employees e join type_employees te on e.id_employee=te.id_type_employee GROUP BY te.name_type_employee ORDER BY COUNT(e.id_employee)DESC",nativeQuery = true)
	public List<String[]> typeTop();

}
