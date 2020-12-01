package com.bcopstein.Entidades.Dominio.Carro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Carro {
    @Id
    private String placa;
    private String marca;
    private String modelo;
    private boolean arcondicionado;
    private boolean direcao;
    private boolean cambioautomatico;
    private boolean disponibilidade;

    public Carro(String placa, String marca, String modelo, boolean arcondicionado, boolean direcao,
            boolean cambioautomatico, boolean disponibilidade) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambioautomatico = cambioautomatico;
        this.disponibilidade = disponibilidade;
    }

    public Carro(){
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public void setArcondicionado(boolean ar) {
        this.arcondicionado = ar;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
    }

    public void locado() {
        this.disponibilidade = false;
    }

    public void liberaLocacao() {
        this.disponibilidade = true;
    }

    public boolean isCambioautomatico() {
        return cambioautomatico;
    }

    public void setCambio(boolean cambio) {
        this.cambioautomatico = cambio;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Carro [arcondicionado=" + arcondicionado + ", cambioautomatico=" + cambioautomatico + ", direcao="
                + direcao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    } 
}
