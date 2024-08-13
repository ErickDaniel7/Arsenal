package br.unipar.programacaointernet.task.task.repository;

import br.unipar.programacaointernet.task.task.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UsuarioRepository {

    @PersistenceContext(unitName = "Maven")
    private EntityManager em;

    public List<Usuario> listarTodos() {
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery
                (jpql, Usuario.class).getResultList();
    }

    public Usuario buscaPorID(Integer id) {
        return em.find(Usuario.class, id);
    }

    public void cadastrar(Usuario usuario)
            throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception e) {
            throw new Exception("Usuário não foi cadastrado");
        }
    }

    public void excluirUsuario(Integer id)
            throws Exception {
        try {
            Usuario usuario = em.find
                    (Usuario.class, id);

            em.remove(usuario);
        } catch (Exception e) {
            throw new Exception("Usuário não foi encontrado");
        }
    }

    public void editarUsuario(Integer id)
            throws Exception {
        try {
            Usuario usuario = em.find
                    (Usuario.class, id);

            em.merge(usuario);
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro, ao atualizar");
        }

    }

}
