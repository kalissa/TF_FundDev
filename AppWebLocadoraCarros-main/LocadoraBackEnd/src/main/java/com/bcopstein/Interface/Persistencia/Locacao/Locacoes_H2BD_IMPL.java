package com.bcopstein.Interface.Persistencia.Locacao;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Locacao.Locacao;
import com.bcopstein.Entidades.Repositorio.Locacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Locacoes_H2BD_IMPL implements Locacoes {
    private Locacao_H2BD_ITF locacao;

    @Autowired
    public Locacoes_H2BD_IMPL(Locacao_H2BD_ITF locacao) {
        this.locacao = locacao;
    }

    @Override
    public void carrega() {
        // Não faz sentido na implementação em BD
    }

    @Override
    public void persiste() {
        // Não faz sentido na implementação em BD
    }

    @Override
    public void cadastra(Locacao item) {
        
        // Insere Locacao nas locações
        locacao.save(item); 
    }

    @Override
    public Collection<Locacao> todos() {
        return locacao.findAll();
    }

    @Override
    public boolean existente(Long chave) {
        return recupera(chave) != null;
    }

    @Override
    public Collection<Locacao> pesquisa(Predicate<Locacao> pred) {
        return locacao.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Locacao elemento) {
        locacao.save(elemento);
    }

    @Override
    public void remove(Long chave) {
        Locacao tmp = recupera(chave);
        locacao.delete(tmp);
    }

    @Override
    public Locacao recupera(Long chave) {
        return locacao.findById(chave).orElse(null);
    }
}
