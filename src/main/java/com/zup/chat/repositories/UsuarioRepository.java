package com.zup.chat.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zup.chat.models.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	 Optional <Usuario> findByEmail(String email);
}
