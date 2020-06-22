package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Bike;

@Repository
public interface IBikeRepository extends JpaRepository<Bike, Integer> {
    @Query("select b from Bike b where b.idBike = :busqueda")
    List<Bike> search(@Param("busqueda") int busqueda);
}
