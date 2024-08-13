package br.unipar.programacaointernet.task.task.repository;

import br.unipar.programacaointernet.task.task.model.Historico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class HistoricoRepository {

    @PersistenceContext(unitName = "Maven")
    private EntityManager em;

    public List<Historico> listarHistoricos() {
        String jpql = "SELECT h FROM Historico h";
        return em.createQuery
                (jpql, Historico.class).getResultList();
    }

    public Historico buscarPorId(Integer id) {
        return em.find(Historico.class, id);
    }

    public void cadastrar(Historico historico)
            throws Exception {
        try {
            em.persist(historico);
        } catch (Exception e) {
            throw new Exception("Histórico não pôde ser cadastrado!");
        }
    }

    public void excluir(Integer id) throws Exception {
        try {
            Historico historico = em.find(Historico.class, id);
            em.remove(historico);
        } catch (Exception e) {
            throw new Exception("Histórico não pôde ser excluído!");
        }
    }

    public void editar(Historico historico, Integer id)
            throws Exception {
        try {
            Historico historicoExistente = em.find(Historico.class, id);

            if (historicoExistente != null) {
                historicoExistente.setDescricao(historico.getDescricao());
                historicoExistente.setDataDeAlteracao(historico.getDataDeAlteracao());
                historicoExistente.setObservacao(historico.getObservacao());
                historicoExistente.setPrioridade(historico.getPrioridade());
                historicoExistente.setStatus(historico.getStatus());
                historicoExistente.setUsuario(historico.getUsuario());
                historicoExistente.setTask(historico.getTask());

                em.merge(historicoExistente);
            } else {
                throw new Exception("O ID está nulo ou não encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro ao editar o histórico");
        }
    }
}
