package com.zup.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.chat.dtos.CadastroUsuarioDto;
import com.zup.chat.dtos.UsuarioResumidoDto;
import com.zup.chat.models.Usuario;
import com.zup.chat.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody CadastroUsuarioDto usuarioDto) {
		Usuario usuarioModel = usuarioDto.converterDTOemUsuario();
		return usuarioService.cadastrarUsuario(usuarioModel);
	}
	
	@GetMapping
	public List<UsuarioResumidoDto> buscarUsuarios(){
		List<Usuario> usuario = usuarioService.listarUsuariosCadastrados();
		return UsuarioResumidoDto.converterListaDeModelParaDTO(usuario);
	}

}
