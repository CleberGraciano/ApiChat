package com.zup.chat.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(unique = true, nullable = false)
	private String email;
	private String cargo;
	
	@OneToMany(mappedBy = "origem")
	private List<Mensagem> mensagensRecebidas;
	
	@OneToMany(mappedBy = "destino")
	private List<Mensagem> mensagensEnviadas;
	
	public Usuario() {
		
		mensagensEnviadas = new ArrayList<>();
		mensagensRecebidas = new ArrayList<>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Mensagem> getMensagensRecebidas() {
		return mensagensRecebidas;
	}

	public void setMensagensRecebidas(List<Mensagem> mensagensRecebidas) {
		this.mensagensRecebidas = mensagensRecebidas;
	}

	public List<Mensagem> getMensagensEnviadas() {
		return mensagensEnviadas;
	}

	public void setMensagensEnviadas(List<Mensagem> mensagensEnviadas) {
		this.mensagensEnviadas = mensagensEnviadas;
	}

	
	
	

}
