package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Status;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer>{

}
