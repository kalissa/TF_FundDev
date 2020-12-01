package com.bcopstein.Interface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CasosDeUso.ControleDeAlugueis;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Interface.DTO.CarroCustoDTO;
import com.bcopstein.Interface.DTO.FiltroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {

  private ControleDeAlugueis controleAlugueis;

  @Autowired
  public LocadoraController(ControleDeAlugueis controleDeAlugueis) {
    controleAlugueis = controleDeAlugueis;
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    // Está selecionando apenas pelos equipamentos
    // Não está verificando se o carro está livre naquelas datas
    Collection<Carro> disponiveis = controleAlugueis.carrosSelecionados(filtro.isArcondicionado(), filtro.isDirecao(), filtro.isCambio());
    List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis.size());
    // Não está calculando o valor das diárias, seguro, desconto ou total
    disponiveis.forEach(c->{
      LocalDate inicioLocacao = LocalDate.of(filtro.getInicioLocacao().getDia(), filtro.getInicioLocacao().getMes(), filtro.getInicioLocacao().getAno());
      LocalDate fimLocacao = LocalDate.of(filtro.getFimLocacao().getDia(), filtro.getFimLocacao().getMes(), filtro.getFimLocacao().getAno());
      float[] valores = controleAlugueis.calculaSubtotal(c, inicioLocacao, fimLocacao);
      informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
                                        filtro.getFimLocacao(),
                                        c.getPlaca(),
                                        c.getMarca(),
                                        c.getModelo(),
                                        c.isArcondicionado(),
                                        c.isDirecao(),
                                        c.isCambioautomatico(),
                                        valores[0], // Total das diárias
                                        valores[1],  // Custo do seguro
                                        valores[2],   // Total do desconto
                                        valores[3])); // Valor a pagar
    });
    return informacoes;
  }

  @PostMapping("/confirmaLocacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody final CarroCustoDTO carroDTO) {
    // Está confirmando qualquer coisa
    LocalDate inicioLocacao = LocalDate.of(carroDTO.getInicioLocacao().getDia(), carroDTO.getInicioLocacao().getMes(), carroDTO.getInicioLocacao().getAno());
    LocalDate fimLocacao = LocalDate.of(carroDTO.getFimLocacao().getDia(), carroDTO.getFimLocacao().getMes(), carroDTO.getFimLocacao().getAno());

    Carro carroLocado = new Carro();

    carroLocado.setPlaca(carroDTO.getPlaca());
    carroLocado.setMarca(carroDTO.getMarca());
    carroLocado.setArcondicionado(carroDTO.isArcondicionado());
    carroLocado.setCambio(carroDTO.isCambio());
    carroLocado.setDirecao(carroDTO.isDirecao());
    
    controleAlugueis.confirmaAluguel(carroLocado, inicioLocacao, fimLocacao);
    return true;
  }

}
