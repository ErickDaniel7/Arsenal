package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Historico;
import br.unipar.programacaointernet.task.task.model.Task;
import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.HistoricoRepository;
import br.unipar.programacaointernet.task.task.repository.TaskRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;
    private final HistoricoRepository historicoRepository;

    public TaskService(TaskRepository taskRepository, HistoricoRepository historicoRepository) {
        this.taskRepository = taskRepository;
        this.historicoRepository = historicoRepository;
    }

    public List<Task> listarTasksService() {
        try {
            return taskRepository.listarTasks();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar as tasks: " + e.getMessage(), e);
        }
    }

    public Task buscarPorIdService(Integer id) {
        return taskRepository.buscarPorId(id);
    }

    public void cadastrarService(Task task) throws Exception {
        try {
            taskRepository.cadastrar(task);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar task: " + e.getMessage());
        }
    }

    public void deletarService(Integer id) throws Exception {
        try {
            taskRepository.deletar(id);
        } catch (Exception e) {
            throw new Exception("Erro ao deletar task: " + e.getMessage());
        }
    }

    public void editarTaskService(Task task, Integer id) throws Exception {
        try {
            Task tarefa = taskRepository.buscarPorId(id);

            if (tarefa == null) {
                throw new Exception("A task com o ID especificado não foi encontrada");
            }

            tarefa.setDescricao(task.getDescricao());
            tarefa.setStatus(task.getStatus());
            tarefa.setUsuario(task.getUsuario());
            tarefa.setObservacao(task.getObservacao());
            tarefa.setPrioridade(task.getPrioridade());

            taskRepository.editarTask(tarefa, id);
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro ao editar a task: " + e.getMessage());
        }
    }

    public void alterarUsuarioDaTarefaService(Integer taskId, Usuario novoUsuario) throws Exception {

        Task task = taskRepository.buscarPorId(taskId);

        if (task == null) {
            throw new Exception("Tarefa não encontrada.");
        }

        Usuario usuarioAtual = task.getUsuario();
        if (usuarioAtual != null) {
            throw new Exception("Já há um usuário atribuído a esta tarefa. Apenas um usuário pode trabalhar em uma tarefa por vez.");
        }

        task.setUsuario(novoUsuario);
        taskRepository.editarTask(task, taskId);
    }

    public void adicionarHistoricoService(Task task, String descricao) {
        Historico historico = new Historico();
        historico.setDescricao(descricao);
        historico.setDataDeAlteracao(LocalDate.from(LocalDateTime.now()));
        historico.setTask(task);

        try {
            historicoRepository.cadastrar(historico);
        } catch (Exception e) {

            System.err.println("Erro ao adicionar histórico: " + e.getMessage());
        }
    }
}
