package com.bcopstein.Entidades.Dominio.Desconto;


import org.springframework.stereotype.Component;

@Component
public class Desconto {
   private double desconto;

   public Desconto () {
      desconto = 0.1;
   }

   public double getDesconto (){
      return desconto;
   }
}