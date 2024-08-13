package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.dto.ClienteQuantidadeVendaDto;
import br.unipar.programacaointernet.pontodevenda.dto.TotalVendaClienteDto;
import br.unipar.programacaointernet.pontodevenda.mapper.QuantidadeVendaMapper;
import br.unipar.programacaointernet.pontodevenda.mapper.TotalVendaMapper;
import br.unipar.programacaointernet.pontodevenda.model.ItensVenda;
import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class VendaService {
  @Inject
  private VendaRepository vendaRepository;

  public List<Venda> listar() {
    return vendaRepository.listar();
  }

  public Venda buscarPorID(Integer id) {
    return vendaRepository.buscarPorID(id);
  }

  public List<Venda> listarPorValorTotal(BigDecimal valor) {
    return vendaRepository.buscarPorValorTotal(valor);
  }

  public void cadastrar(Venda venda) throws Exception {
    for (ItensVenda item : venda.getItens()) {
      item.setVenda(venda);
    }

    vendaRepository.cadastrar(venda);
  }

  public void editar(Venda venda) throws Exception {
    vendaRepository.editar(venda);
  }

  public void excluir(Venda venda) throws Exception {
    vendaRepository.excluir(venda);
  }

  public List<TotalVendaClienteDto> listarVendaTotal() {
    List<Venda> listVenda = vendaRepository.listar();
    return TotalVendaMapper.toDTO(listVenda);
  }

  public List<ClienteQuantidadeVendaDto> listarVendaQuantidade() {
    List<Venda> listVenda = vendaRepository.listar();
    return QuantidadeVendaMapper.toDTO(listVenda);
  }
}
