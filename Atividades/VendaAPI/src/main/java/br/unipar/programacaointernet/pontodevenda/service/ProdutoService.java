package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.dto.ProdutoDescricaoValorDto;
import br.unipar.programacaointernet.pontodevenda.mapper.ProdutoMapper;
import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService {

  @Inject
  private ProdutoRepository produtoRepository;

  public List<Produto> listar() {
    return produtoRepository.listar();
  }

  public Produto buscarPorID(Integer id) {
    return produtoRepository.buscarPorID(id);
  }

  public void cadastrar(Produto produto) throws Exception {
    produtoRepository.cadastrar(produto);
  }

  public void editar(Produto produto) throws Exception {
    produtoRepository.editar(produto);
  }

  public void excluir(Produto produto) throws Exception {
    produtoRepository.excluir(produto);
  }

  public List<ProdutoDescricaoValorDto> listarProdutoDescricao() {
    List<Produto> listProduto = produtoRepository.listar();
    return ProdutoMapper.toDTO(listProduto);
  }
}
