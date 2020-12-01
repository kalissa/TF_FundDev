package com.bcopstein.Interface.Persistencia.Garagem;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Repositorio.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Carros_H2BD_IMPL implements Carros {
    private Garagem_H2BD_ITF garagem;

    @Autowired
    public Carros_H2BD_IMPL(Garagem_H2BD_ITF garagem) {
        this.garagem = garagem;
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
    public void cadastra(Carro carro) {
        
        // Insere Carro na Garagem
        garagem.save(carro); 
    }

    @Override
    public Collection<Carro> todos() {
        return garagem.findAll();
    }

    @Override
    public boolean existente(String chave) {
        return recupera(chave) != null;
    }

    @Override
    public Collection<Carro> pesquisa(Predicate<Carro> pred) {
        return garagem.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Carro elemento) {
        garagem.save(elemento);
    }

    @Override
    public void remove(String chave) {
        Carro tmp = recupera(chave);
        garagem.delete(tmp);
    }

    @Override
    public Carro recupera(String chave) {
        return garagem.findById(chave).orElse(null);
    }
}
