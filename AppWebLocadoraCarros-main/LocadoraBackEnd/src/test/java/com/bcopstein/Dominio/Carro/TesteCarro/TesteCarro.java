package com.bcopstein.Dominio.Carro.TesteCarro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteCarro {
    Carro c1 = null;

    @BeforeEach
    void setUp(){
        c1 = new Carro("ASQ4932","AUDI", "Q3", true, true, true, true);
    }

    @Test
    public void testaIsDisponivel(){
        Assertions.assertEquals(true, c1.isDisponivel());
    }
}