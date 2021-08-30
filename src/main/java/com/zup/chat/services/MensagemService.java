package com.zup.chat.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.chat.models.Mensagem;
import com.zup.chat.models.Usuario;
import com.zup.chat.repositories.MensagemRepository;

@Service
public class MensagemService {

	private UsuarioService usuarioService;
	private MensagemRepository mensagemRepository;
	
	 @Autowired
	 public MensagemService(MensagemRepository mensagemRepository, UsuarioService usuarioService) {
	        this.mensagemRepository = mensagemRepository;
	        this.usuarioService = usuarioService;
	    }
	 
	 
	 public Mensagem cadastrarMensagem(String origem, String destino, Mensagem mensagem) {
		 
		 Usuario usuarioOrigem = usuarioService.buscarUsuarioPorEmail(origem);
		 Usuario usuarioDestino = usuarioService.buscarUsuarioPorEmail(destino);
		 
		 validaUsuarioRepedido(origem, destino);
		 
		 mensagem.setOrigem(usuarioOrigem);
		 mensagem.setDestino(usuarioDestino);
		 mensagem.setDataDeEnvio(LocalDate.now());
		 mensagem.setVisualizado(false);
		 
		 return mensagemRepository.save(mensagem);
		 
	 }
	 
	 private boolean validaUsuarioRepedido(String userDestino, String userOrigem) {
		 
		 if (userOrigem.equals(userDestino)) {
			 throw new RuntimeException("Você não pode enviar uma mensagem para você mesmo");
		}
		 return true;
		
	 }
	 
	 public List<Mensagem> filtrarMengensPor(String emailUsuario, Boolean visualizado){
	        if(emailUsuario != null){
	            return mensagemRepository.findAllByDestinoEmailContains(emailUsuario);
	        }if(visualizado != null){
	            return mensagemRepository.findAllByVisualizado(visualizado);
	        }

	        return (List<Mensagem>) mensagemRepository.findAll();
	    }
	
	 
}
