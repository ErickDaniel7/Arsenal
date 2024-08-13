package br.unipar.consomecep.bibliotecaapi.repository;

import br.unipar.consomecep.bibliotecaapi.model.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class LivroRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Livro> listar() {
        String jpql = "SELECT l FROM Livro l";
        return em.createQuery(jpql, Livro.class).getResultList();
    }

    public void cadastrar(Livro livro) throws Exception {

        try {
            em.persist(livro);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser cadastrado");
        }
    }

}
