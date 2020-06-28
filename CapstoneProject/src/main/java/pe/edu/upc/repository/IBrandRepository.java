package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer>{
    
	@Query("select count(c.nameBrand) from Brand c where c.nameBrand=LOWER(:nameBrand) or c.nameBrand=UPPER(:nameBrand)or c.nameBrand=:nameBrand")
	public int searchBrand(@Param("nameBrand")String nombre);
	

	@Query(value = "select br.name_brand,count(rt.id_rental_ticket) from bikes b join brands br on b.id_bike=br.id_brand join rental_tickets rt on br.id_brand=rt.id_bike GROUP BY br.name_brand ORDER BY COUNT(rt.id_rental_ticket)DESC",nativeQuery = true)
    public List<String[]> brandTop();

}
