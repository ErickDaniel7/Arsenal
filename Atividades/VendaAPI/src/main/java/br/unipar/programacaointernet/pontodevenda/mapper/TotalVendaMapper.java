package br.unipar.programacaointernet.pontodevenda.mapper;

import br.unipar.programacaointernet.pontodevenda.dto.TotalVendaClienteDto;
import br.unipar.programacaointernet.pontodevenda.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class TotalVendaMapper {
  public static List<TotalVendaClienteDto> toDTO(List<Venda> vendaList) {
    List<TotalVendaClienteDto> dtoList = new ArrayList<>();
    for (Venda venda : vendaList) {
      TotalVendaClienteDto dto = new TotalVendaClienteDto();
      dto.setNome(venda.getCliente().getNome());
      dto.setValorTotal(venda.getTotal());

      dtoList.add(dto);
    }
    return dtoList;
  }
}
