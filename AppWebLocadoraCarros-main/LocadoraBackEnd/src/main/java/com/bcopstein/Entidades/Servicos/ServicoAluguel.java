package com.bcopstein.Entidades.Servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Desconto.Desconto;
import com.bcopstein.Entidades.Dominio.Seguro.Seguro;
import com.bcopstein.Entidades.Repositorio.Carros;
import com.bcopstein.Entidades.Repositorio.Locacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoAluguel {
    private float valorAluguel;
    private Desconto desconto;
    private Seguro seguro;

    @Autowired
    public ServicoAluguel(Carros carros, Locacoes locacoes, Desconto desconto, Seguro seguro) {
        this.desconto = desconto;
        this.seguro = seguro;
    }

    public float calculaSubtotal(Carro carro, LocalDate inicioLocacao, LocalDate fimLocacao) {
        float periodoLocacao = ChronoUnit.DAYS.between(inicioLocacao, fimLocacao);
        valorAluguel = periodoLocacao * 100; // periodo da locação * o valor da diária; 
        if(carro.isArcondicionado()){
            valorAluguel += 200;
        }

        if(carro.isCambioautomatico()){
            valorAluguel += 100.00;
        }

        if(carro.isDirecao()){
            valorAluguel += 50.00;
        }
        return valorAluguel;
    }

    public float calculaDesconto() {
        valorAluguel += desconto.getDesconto();
        return valorAluguel;
    }

    public float calculaSeguro() {
        valorAluguel += seguro.getSeguro();
        return valorAluguel;
    }

    public float calculaPrecoFinal() {
        return valorAluguel;
    }

    public float[] todosValores(Carro carro, LocalDate inicioLocacao, LocalDate fimLocacao) {  // TRAZER O CARRO DA WEB FILTRADO COM SUAS CARACTERISTICAS?
        float[] valores = new float[4];
        valores[0] = calculaSubtotal(carro, inicioLocacao, fimLocacao);
        valores[1] = calculaSeguro();
        valores[2] = calculaDesconto();
        valores[3] = calculaPrecoFinal();
        return valores;
    } //tem que criar esses métodos em carro

}