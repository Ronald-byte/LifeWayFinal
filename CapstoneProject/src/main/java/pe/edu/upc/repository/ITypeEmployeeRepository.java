package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.TypeEmployee;

@Repository
public interface ITypeEmployeeRepository extends JpaRepository<TypeEmployee, Integer>{


}
