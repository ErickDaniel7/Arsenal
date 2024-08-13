package br.unipar.programacaointernet.pontodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDescricaoValorDto {
  private String descricao;
  private BigDecimal valorUnitario;
}
