package com.bcopstein.Interface.Persistencia.Locacao;

import java.util.List;

import com.bcopstein.Entidades.Dominio.Locacao.Locacao;

import org.springframework.data.repository.CrudRepository;

public interface Locacao_H2BD_ITF extends CrudRepository<Locacao, Long> {
    List<Locacao> findByIdLocacao(Long idLocacao);
    List<Locacao> findAll();    
}
