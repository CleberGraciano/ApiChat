package com.zup.chat.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zup.chat.dtos.ChatDto;
import com.zup.chat.dtos.MensagemDto;
import com.zup.chat.dtos.MensagemResumoDto;
import com.zup.chat.models.Mensagem;
import com.zup.chat.services.MensagemService;

@RestController
@RequestMapping("chat")
public class ChatController {
	
	@Autowired
	MensagemService mensagemService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping()
	public MensagemDto cadastrarMensagem(@RequestBody @Valid ChatDto chatDto) {
		Mensagem mensagem = chatDto.converterDTOemMensagem();
		mensagem = mensagemService.cadastrarMensagem(chatDto.getOrigem(), chatDto.getDestino(), mensagem);
		return MensagemDto.converterModelParaDTO(mensagem);
	}
	
	@GetMapping("/usuario/perfil/{emailUsuario}")
    public List<MensagemResumoDto> pesquisarMensagens(@PathVariable String emailUsuario,
                                             @RequestParam(required = false) Boolean visualizado){
        List<Mensagem> mensagens = mensagemService.filtrarMengensPor(emailUsuario, visualizado);
        List<MensagemResumoDto> mensagemResumoDtos = mensagens.stream()
                .map(mensagem -> modelMapper.map(mensagem, MensagemResumoDto.class)).collect(Collectors.toList());
        return mensagemResumoDtos;
    }

}
