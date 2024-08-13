package br.unipar.programacaointernet.pontodevenda.mapper;

import br.unipar.programacaointernet.pontodevenda.dto.ProdutoDescricaoValorDto;
import br.unipar.programacaointernet.pontodevenda.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {

  public static List<ProdutoDescricaoValorDto> toDTO(List<Produto> produtoList) {
    List<ProdutoDescricaoValorDto> dtoList = new ArrayList<>();
    for (Produto produto : produtoList) {
      ProdutoDescricaoValorDto dto = new ProdutoDescricaoValorDto();
      dto.setDescricao(produto.getDescricao());
      dto.setValorUnitario(produto.getValor_unitario());

      dtoList.add(dto);
    }
    return dtoList;
  }
}
