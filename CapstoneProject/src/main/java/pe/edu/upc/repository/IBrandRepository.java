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
	
	@Query(value = "select br.brand_name,count(b.id_bike) from public.rentalticket i join rentalticket ide on ide.id_rentalticket = i.id_rentaltikect join bikes b on ide.id_bike = b.id_bike join brands br on br.id_brand = b.id_brand group by br.brand_name ORDER BY COUNT(br.brand_name)DESC limit 1",nativeQuery = true)
	public List<String[]> brandTop();

}
