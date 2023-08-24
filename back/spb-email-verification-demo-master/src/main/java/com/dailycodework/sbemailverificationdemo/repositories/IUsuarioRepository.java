/*
 * package com.dailycodework.sbemailverificationdemo.repositories;
 * 
 * 
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.dailycodework.sbemailverificationdemo.entities.Escuela; import
 * com.dailycodework.sbemailverificationdemo.entities.Rol; import
 * com.dailycodework.sbemailverificationdemo.entities.Usuario;
 * 
 * 
 * 
 * 
 * @Repository public interface IUsuarioRepository extends
 * JpaRepository<Usuario,Long>{ public Usuario findUsuarioById(Long id); public
 * Usuario findUsuarioByUsername(String username); public List<Usuario>
 * findUsuarioByEscuela(Escuela escuela);
 * 
 * //J-verificar docentes public List<Usuario> findByRolId(Long rolId);
 * 
 * @Query("SELECT u FROM Usuario u WHERE u.nombres LIKE %:nombres% AND u.rol = :rol"
 * ) List<Usuario> findByNombresContainingAndRol(String nombres, Rol rol); }
 */