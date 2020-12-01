package com.bcopstein.Entidades.Dominio.Locacao;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.DataLocal;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idLocacao;
    private DataLocal inicioLocacao;
    private DataLocal fimLocacao;
    private Carro carro;
    private float subtotal;
    private float desconto;
    private float seguro;
    private float valorFinal;
    private boolean fechada;

    public Locacao(long idLocacao, DataLocal inicioLocacao, DataLocal fimLocacao, Carro carroLocado, float subtotal, float desconto, float seguro, float valorFinal, boolean fechada) {
        this.idLocacao = idLocacao;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.carro = carroLocado;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.seguro = seguro;
        this.valorFinal = valorFinal;
        this.fechada = fechada;
    }

    public Locacao(){}

    public DataLocal getInicioLocacao() {
        return inicioLocacao;
    }
    public DataLocal getFimLocacao(){
        return fimLocacao;
    }

    public Carro getCarro() {
        return carro;
    }
    
    public float getSubtotal() {
        return subtotal;
    }

    public float getDesconto() {
        return desconto;
    }

    public float getSeguro() {
        return seguro;
    }

    public float getValorFinal() {
        return valorFinal;
    }
    
    public boolean getFechada() {
        return fechada;
    }

    public boolean disponivel() {
        return carro.isDisponivel();
    }

    public boolean addCarro(Carro carro)   {
        if(!fechada && carro.isDisponivel())    {
                this.carro = carro;
                return true;
        }
        return false;
    }

    public void fechaAluguel(float subtotal, float desconto, float seguro, float valorFinal)  {
        fechada = true;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.seguro = seguro;
        this.valorFinal = valorFinal;
    }
    
    @Override
  public String toString() {
    return "Locacao [Data da Locacao=" + inicioLocacao + ", Carro=" + carro + ", Valor da locação=" + valorFinal + "]";
  }
  
}






