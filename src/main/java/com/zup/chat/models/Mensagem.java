package com.zup.chat.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "mensagens")
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_origem", nullable = false)
    private Usuario origem;
    
    @ManyToOne
    @JoinColumn(name = "usuario_destino", nullable = false)
    private Usuario destino;

	public Mensagem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDate getDataDeEnvio() {
		return dataDeEnvio;
	}

	public void setDataDeEnvio(LocalDate dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}

	public boolean isVisualizado() {
		return visualizado;
	}

	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}

	public Usuario getOrigem() {
		return origem;
	}

	public void setOrigem(Usuario origem) {
		this.origem = origem;
	}

	public Usuario getDestino() {
		return destino;
	}

	public void setDestino(Usuario destino) {
		this.destino = destino;
	}

	

}
