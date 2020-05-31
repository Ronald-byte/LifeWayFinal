package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.TypeEmployee;

@Repository
public interface ITypeEmployeeRepository extends JpaRepository<TypeEmployee, Integer> {
	@Query("select count(c.nameTypeEmployee) from TypeEmployee c where c.nameTypeEmployee=UPPER(:nameTypeEmployee) or c.nameTypeEmployee=LOWER(:nameTypeEmployee)")
	public int seachTypeEmployee(@Param("nameTypeEmployee") String nombre);

}
