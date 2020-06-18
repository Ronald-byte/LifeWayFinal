package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select count(e.dniEmployee) from Employee e where e.dniEmployee=:dniEmployee")
	public int seachDni(@Param("dniEmployee") String dni);

	@Query("from Employee e where e.nameEmployee like %:busqueda% or e.paternalSurnameEmployee like %:busqueda% or e.maternalSurnameEmployee like %:busqueda% or e.emailEmployee like %:busqueda% or e.phoneNumberEmployee like %:busqueda% or e.dniEmployee like %:busqueda% or e.typeEmployee.nameTypeEmployee like %:busqueda%")
	List<Employee> search(@Param("busqueda") String busqueda);

}
