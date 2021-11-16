package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uc.us_security.entity.Usuario;

public interface Usuariorepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
}
