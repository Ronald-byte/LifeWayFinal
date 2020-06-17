package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Bike;

@Repository
public interface IBikeRepository extends JpaRepository<Bike, Integer> {
	
}
