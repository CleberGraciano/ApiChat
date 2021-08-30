package com.zup.chat.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.zup.chat.models.Usuario;

public class CadastroUsuarioDto {
	
	@Size(message = "Minimo 2 letras", min=2)
	private String nome;
	@Email(message = "Email fora do padrao")
	private String email;
	private String cargo;
	
	public CadastroUsuarioDto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	public Usuario converterDTOemUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setCargo(cargo);
		
		return usuario;
	}
	
	
	

}
