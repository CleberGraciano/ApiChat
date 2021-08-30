package com.zup.chat.dtos;

import java.time.LocalDate;

import com.zup.chat.models.Mensagem;

public class MensagemDto {
	private int id;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;
    
    private UsuarioDto usuarioDtoOrigem;
    private UsuarioDto usuarioDtoDestino;
    
	public MensagemDto() {
	
	}
	
	
	public MensagemDto(int id, String mensagem, LocalDate dataDeEnvio, boolean visualizado, UsuarioDto usuarioDtoOrigem,
			UsuarioDto usuarioDtoDestino) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.dataDeEnvio = dataDeEnvio;
		this.visualizado = visualizado;
		this.usuarioDtoOrigem = usuarioDtoOrigem;
		this.usuarioDtoDestino = usuarioDtoDestino;
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


	public UsuarioDto getUsuarioDtoOrigem() {
		return usuarioDtoOrigem;
	}


	public void setUsuarioDtoOrigem(UsuarioDto usuarioDtoOrigem) {
		this.usuarioDtoOrigem = usuarioDtoOrigem;
	}


	public UsuarioDto getUsuarioDtoDestino() {
		return usuarioDtoDestino;
	}


	public void setUsuarioDtoDestino(UsuarioDto usuarioDtoDestino) {
		this.usuarioDtoDestino = usuarioDtoDestino;
	}


	public static MensagemDto converterModelParaDTO(Mensagem mensagem){
		 MensagemDto mensagDto = new MensagemDto();
	     UsuarioDto usuarioDtoOrigem = UsuarioDto.converterModelParaDTO(mensagem.getOrigem());
	     UsuarioDto usuarioDtoDestino = UsuarioDto.converterModelParaDTO(mensagem.getDestino());
	     mensagDto.setUsuarioDtoOrigem(usuarioDtoOrigem);
	     mensagDto.setUsuarioDtoDestino(usuarioDtoDestino);
	     mensagDto.setMensagem(mensagem.getMensagem());
	     mensagDto.setVisualizado(mensagem.isVisualizado());
	     mensagDto.setDataDeEnvio(mensagem.getDataDeEnvio());
	     mensagDto.setId(mensagem.getId());

	        return mensagDto;
	    }
    
    

}
