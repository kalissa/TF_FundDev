package com.bcopstein.Dominio.Desconto;


import com.bcopstein.Entidades.Dominio.Desconto.Desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteDesconto {
    Desconto desconto1 = null;


    @BeforeEach
    void setUp(){
        desconto1 = new Desconto();
    }

    @Test
    public void testeDesconto(){
        double valorDesconto = 0.1;
        Assertions.assertEquals(valorDesconto, desconto1.getDesconto());

    }
}