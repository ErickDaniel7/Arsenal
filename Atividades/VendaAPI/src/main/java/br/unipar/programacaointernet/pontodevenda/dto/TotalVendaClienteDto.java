package br.unipar.programacaointernet.pontodevenda.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalVendaClienteDto {
  private String nome;
  private BigDecimal valorTotal;
}
