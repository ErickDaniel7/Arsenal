package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Historico;
import br.unipar.programacaointernet.task.task.repository.HistoricoRepository;

import java.util.List;

public class HistoricoService {
    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public List<Historico> listarHistoricosService() {
        try {
            return historicoRepository.listarHistoricos();
        } catch (Exception e) {

            System.err.println("Erro ao listar históricos: " + e.getMessage());
            return null;
        }
    }

    public Historico buscaPorIdService(Integer id) {
        try {
            return historicoRepository.buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar histórico por ID: " + e.getMessage());
            return null;
        }
    }

    public void cadastroService(Historico historico) throws Exception {
        try {
            historicoRepository.cadastrar(historico);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar histórico: " + e.getMessage());
        }
    }

    public void excluirService(Integer id) throws Exception {
        try {
            historicoRepository.excluir(id);
        } catch (Exception e) {
            throw new Exception("Erro ao excluir histórico: " + e.getMessage());
        }
    }

    public void editarService(Historico historico, Integer id) throws Exception {
        try {
            historicoRepository.editar(historico, id);
        } catch (Exception e) {
            throw new Exception("Erro ao editar histórico: " + e.getMessage());
        }
    }

    public void atualizarDescricaoService(Integer id, String novaDescricao) throws Exception {
        Historico historico = historicoRepository.buscarPorId(id);
        if (historico != null) {
            historico.setDescricao(novaDescricao);
            historicoRepository.editar(historico, id);
        } else {
            throw new Exception("Histórico com o ID fornecido não encontrado.");
        }
    }

    public void atualizarStatusService(Integer id, String novoStatus) throws Exception {
        Historico historico = historicoRepository.buscarPorId(id);
        if (historico != null) {
            historico.setStatus(novoStatus);
            historicoRepository.editar(historico, id);
        } else {
            throw new Exception("Histórico com o ID fornecido não encontrado.");
        }
    }
}
