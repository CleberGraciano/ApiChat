package com.zup.chat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.chat.models.Usuario;
import com.zup.chat.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listarUsuariosCadastrados(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public boolean usuarioExistente(int id) {
        return usuarioRepository.existsById(id);
    }
	
	 public Usuario buscarUsuarioPeloId(int id){
	        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

	        if(usuarioOptional.isPresent()){
	            return usuarioOptional.get();
	        }
	        throw new RuntimeException("Usuario não encontrado");

	    }
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Optional<Usuario> usuOptional = usuarioRepository.findByEmail(email);
		
		if (usuOptional.isPresent()) {
			return usuOptional.get();
		}
		return null;
	}
		

}
