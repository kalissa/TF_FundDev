package com.bcopstein.Interface.Persistencia.Garagem;

import java.util.List;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

import org.springframework.data.repository.CrudRepository;

public interface Garagem_H2BD_ITF extends CrudRepository<Carro, String> {
    List<Carro> findByPlaca(String placa);
    List<Carro> findAll();    
}
