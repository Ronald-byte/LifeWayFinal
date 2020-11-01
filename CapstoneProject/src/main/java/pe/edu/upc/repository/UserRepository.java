package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("select count(c.username) from Users c where c.username=UPPER(:username) or c.username=LOWER(:username) or c.username=:username")
	public int seachusername(@Param("username") String nombre);
	public Users findByUsername(String username);


}