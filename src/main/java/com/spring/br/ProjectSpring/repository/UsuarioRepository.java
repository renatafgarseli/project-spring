package com.spring.br.ProjectSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.br.ProjectSpring.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByNameContainingIgnoreCase(String name);

	List<Usuario> findByNameAndEmail(String name, String email);

	List<Usuario> findByNameIn(List<String> names);

	@Query("FROM Usuario c WHERE c.id = :id")
	void jpqlQuery(@Param("id") Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM usuario c WHERE c.id = :id")
	void nativeQuery(@Param("id") Long id);
}
