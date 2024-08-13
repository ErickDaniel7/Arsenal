package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.dto.NomeTelefoneAniversarioDto;
import br.unipar.programacaointernet.pontodevenda.mapper.ClienteMapper;
import br.unipar.programacaointernet.pontodevenda.mapper.ProdutoMapper;
import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {
  @Inject
  private ClienteRepository clienteRepository;

  public List<Cliente> listar() {
    return clienteRepository.listar();
  }

  public Cliente buscarPorID(Integer id) {
    return clienteRepository.buscarPorID(id);
  }

  public void cadastrar(Cliente cliente) throws Exception {
    clienteRepository.cadastrar(cliente);
  }

  public void editar(Cliente cliente) throws Exception {
    clienteRepository.editar(cliente);
  }

  public void excluir(Cliente cliente) throws Exception {
    clienteRepository.excluir(cliente);
  }

  public List<NomeTelefoneAniversarioDto> listarClienteResumo() {
    List<Cliente> listCliente = clienteRepository.listar();
    return ClienteMapper.toDTO(listCliente);
  }
}
