package com.bcopstein.CasosDeUso;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Locacao.Locacao;
import com.bcopstein.Entidades.Servicos.ServicoAluguel;
import com.bcopstein.Entidades.Repositorio.Locacoes;
import com.bcopstein.Entidades.Repositorio.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControleDeAlugueis {
  private Carros carros;
  private ServicoAluguel servicoAluguel;
  private Locacoes locacoes;
  private Locacao locacaoAndamento;

  public Carro carroLocado;

  @Autowired
  public ControleDeAlugueis(Carros carros,ServicoAluguel servicoAluguel,Locacoes locacoes) {
    this.carros = carros;
    this.servicoAluguel = servicoAluguel;
    this.locacoes = locacoes;
  }

  public void confirmaAluguel(final Carro carro, LocalDate inicioLocacao, LocalDate fimLocacao) {
    float[] valores = servicoAluguel.todosValores(carro, inicioLocacao, fimLocacao);
    locacaoAndamento = new Locacao();
    locacaoAndamento.addCarro(carro);
    carro.locado();
    carros.atualiza(carro);
    locacaoAndamento.fechaAluguel(valores[0], valores[1], valores[2], valores[3]);
    locacoes.cadastra(locacaoAndamento);
  }

  public Collection<Locacao> locacoesEfetuadas() {
    return locacoes.todos();
  }

  public Collection<Carro> carrosSelecionados(boolean ar ,boolean direcao ,boolean cambio) {
    return carros.pesquisa(c->c.isArcondicionado() == ar && c.isDirecao() == direcao && c.isCambioautomatico() == cambio);
  }

  public float[] calculaSubtotal(final Carro carro,final LocalDate inicioLocacao, LocalDate fimLocacao) {
    // Calcula os valores e retorna
    return servicoAluguel.todosValores(carro, inicioLocacao, fimLocacao);
  }
}
