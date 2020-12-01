package com.bcopstein.Entidades.Dominio.Seguro;

import org.springframework.stereotype.Component;

@Component
public class Seguro {
    private double seguro;
 
    public Seguro () {
       seguro = 0.05;
    }
 
    public double getSeguro (){
       return seguro;
    }
 }