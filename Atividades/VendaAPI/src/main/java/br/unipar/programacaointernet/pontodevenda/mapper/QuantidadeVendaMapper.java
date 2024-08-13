package br.unipar.programacaointernet.pontodevenda.mapper;


import br.unipar.programacaointernet.pontodevenda.dto.ClienteQuantidadeVendaDto;
import br.unipar.programacaointernet.pontodevenda.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class QuantidadeVendaMapper {
  public static List<ClienteQuantidadeVendaDto> toDTO(List<Venda> vendaList) {
    List<ClienteQuantidadeVendaDto> dtoList = new ArrayList<>();
    for (Venda venda : vendaList) {
      var nome = venda.getCliente().getNome();
      var quantidade = 0;
      for (Venda venda2 : vendaList) {
        if (venda2.getCliente().getNome() == nome) {
          quantidade++;
        }
      }
      ClienteQuantidadeVendaDto dto = new ClienteQuantidadeVendaDto();
      dto.setQuantidade(quantidade);
      dto.setNome(venda.getCliente().getNome());

      dtoList.add(dto);
    }
    return dtoList;
  }
}
