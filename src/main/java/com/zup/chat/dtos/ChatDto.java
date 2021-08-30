package com.zup.chat.dtos;

import com.zup.chat.models.Mensagem;

public class ChatDto {
	
	private String mensagem;
	private String origem;
	private String destino;
	
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getMensagem() {
		return mensagem;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getOrigem() {
		return origem;
	}



	public void setOrigem(String origem) {
		this.origem = origem;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public Mensagem converterDTOemMensagem() {
			
		Mensagem mensagem = new Mensagem();
		mensagem.setMensagem(this.mensagem);
		return mensagem;
	}
	


}
