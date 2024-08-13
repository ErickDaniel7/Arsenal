package br.unipar.programacaointernet.pontodevenda.mapper;

import br.unipar.programacaointernet.pontodevenda.dto.NomeTelefoneAniversarioDto;
import br.unipar.programacaointernet.pontodevenda.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {
  public static List<NomeTelefoneAniversarioDto> toDTO(List<Cliente> clienteList) {
    List<NomeTelefoneAniversarioDto> dtoList = new ArrayList<>();
    for (Cliente venda : clienteList) {
      NomeTelefoneAniversarioDto dto = new NomeTelefoneAniversarioDto();
      dto.setNome(venda.getNome());
      dto.setTelefone(venda.getTelefone());
      dto.setAniversario(venda.getAniversario());

      dtoList.add(dto);
    }
    return dtoList;
  }

}
