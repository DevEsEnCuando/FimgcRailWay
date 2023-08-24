package com.dailycodework.sbemailverificationdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.Rol;


import java.util.List;
import java.util.Optional;

/**
 * @author Sampson Alfred
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	public User findUsuarioById(Long id);
	public User findUsuarioByFirstName(String firstName);
	public List<User> findUsuarioByEscuela(Escuela escuela);
	
	//J-verificar docentes
	public List<User> findByRolId(Long rolId);
	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:firstName% AND u.rol = :rol")
    List<User> findByNombresContainingAndRol(String firstName, Rol rol);
}
