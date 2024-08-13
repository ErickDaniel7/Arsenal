package br.unipar.programacaoweb.apivenda.repository;

import br.unipar.programacaoweb.apivenda.model.Venda;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless

public class VendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarVenda(Venda venda) throws Exception {
        try {
            em.persist(venda);
        } catch (Exception ex) {
            throw new Exception("Estante não pode ser cadastrado");
        }
    }

    public List<Venda> getVendas() {
        String jpql = "SELECT l FROM Venda l";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

}
