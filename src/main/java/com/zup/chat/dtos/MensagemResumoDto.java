package com.zup.chat.dtos;

import java.time.LocalDate;

public class MensagemResumoDto {
	
	private int id;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;
    
	public MensagemResumoDto() {
	
	}

	public MensagemResumoDto(int id, String mensagem, LocalDate dataDeEnvio, boolean visualizado) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.dataDeEnvio = dataDeEnvio;
		this.visualizado = visualizado;
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
	
	
    

}
