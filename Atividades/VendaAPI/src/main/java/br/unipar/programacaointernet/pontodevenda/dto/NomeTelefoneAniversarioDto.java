package br.unipar.programacaointernet.pontodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NomeTelefoneAniversarioDto {
  private String nome;
  private String telefone;
  private String aniversario;
}
