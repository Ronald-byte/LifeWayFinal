package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Status;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer>{

	@Query("select count(c.nameStatus) from Status c where c.nameStatus=LOWER(:nameStatus) or c.nameStatus=UPPER(:nameStatus)")
	public int searchCategory(@Param("nameStatus")String nombre);
}
