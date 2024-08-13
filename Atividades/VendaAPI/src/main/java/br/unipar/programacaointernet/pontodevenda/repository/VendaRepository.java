package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class VendaRepository {
  @PersistenceContext(unitName = "HibernateMaven")
  private EntityManager em;


  public List<Venda> listar() {
    String jpql = "SELECT p FROM Venda p";
    return em.createQuery(jpql, Venda.class).getResultList();
  }

  public Venda buscarPorID(Integer id) {
    return em.find(Venda.class, id);
  }

  public List<Venda> buscarPorValorTotal(BigDecimal valor) {
    String jpql = "SELECT p FROM Venda p WHERE p.total = :valor";
    return em.createQuery(jpql, Venda.class).setParameter("valor", valor).getResultList();
  }

  public void cadastrar(Venda venda) throws Exception {
    try {
      em.persist(venda);
    } catch (Exception ex) {
      throw new Exception("Venda não pode ser cadastrado");
    }
  }

  public void editar(Venda venda) throws Exception {
    try {
      em.merge(venda);
    } catch (Exception ex) {
      throw new Exception("Venda não pode ser editado");
    }
  }

  public void excluir(Venda venda) throws Exception {
    try {
      em.remove(em.getReference(Venda.class, venda.getId()));
    } catch (Exception ex) {
      throw new Exception("Venda não pode ser excluído.");
    }
  }
}
