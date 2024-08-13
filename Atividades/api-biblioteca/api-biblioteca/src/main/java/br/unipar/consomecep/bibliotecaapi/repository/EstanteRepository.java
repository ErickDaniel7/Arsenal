package br.unipar.consomecep.bibliotecaapi.repository;

import br.unipar.consomecep.bibliotecaapi.model.Estante;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless
public class EstanteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    private UserTransaction utx;

    public void cadastrarEstante(Estante estante) throws Exception{

        try {
            em.persist(estante);
        } catch (Exception ex) {
            throw new Exception("A Estante não pode ser cadastrada!");
        }
    }

    public List<Estante> getEstantes() {
        String listaEstantes = "SELECT a FROM Estante a";
        return em.createQuery(listaEstantes, Estante.class).getResultList();
    }
}
