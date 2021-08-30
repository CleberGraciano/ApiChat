package com.zup.chat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zup.chat.models.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
	
	List<Mensagem> findAllByVisualizado(boolean visualizado);
    List<Mensagem> findAllByDestinoEmailContains(String nome);
	
}
