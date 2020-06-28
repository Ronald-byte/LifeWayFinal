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
	
	@Query(value = "select br.name_brand,count(b.id_bike) from bikes b join brands br on b.id_brand=br.id_brand GROUP BY br.name_brand ORDER BY COUNT(b.id_bike)DESC",nativeQuery = true)
	public List<String[]> brandTop();

	
}
