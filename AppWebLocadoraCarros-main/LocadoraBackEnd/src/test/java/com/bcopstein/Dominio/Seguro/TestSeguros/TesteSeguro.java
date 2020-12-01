package com.bcopstein.Dominio.Seguro.TestSeguros;

import org.junit.jupiter.api.Assertions;
import com.bcopstein.Entidades.Dominio.Seguro.Seguro;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Seguro.Seguro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteSeguro {

    Seguro seguro1 = null;


    @BeforeEach
    void setUp(){        
        seguro1 = new Seguro();
    }

    @Test
    public void testeSeguro(){
        double valorSeguro = 0.5;
        Assertions.assertEquals(valorSeguro, seguro1.getSeguro());
    }

}