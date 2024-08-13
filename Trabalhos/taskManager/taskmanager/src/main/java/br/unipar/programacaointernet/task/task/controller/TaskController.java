package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Task;
import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.TaskRepository;
import br.unipar.programacaointernet.task.task.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tasks")
public class TaskController {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private TaskService taskService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> listarTasks() {
        return taskRepository.listarTasks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task buscarPorId(@PathParam("id") Integer id) {
        return taskRepository.buscarPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrar(Task task) throws Exception {
        taskRepository.cadastrar(task);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Integer id) throws Exception {
        taskRepository.deletar(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Task task, @PathParam("id") Integer id) throws Exception {
        taskRepository.editarTask(task, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> listarTasksService() {
        return taskService.listarTasksService();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task buscarPorIdService(@PathParam("id") Integer id) {
        return taskService.buscarPorIdService(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarService(Task task) throws Exception {
        taskService.cadastrarService(task);
    }

    @DELETE
    @Path("/{id}")
    public void deletarService(@PathParam("id") Integer id) throws Exception {
        taskService.deletarService(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarService(Task task, @PathParam("id") Integer id) throws Exception {
        try {
            Task tarefaExistente = taskService.buscarPorIdService(id);
            if (tarefaExistente == null) {
                throw new NotFoundException("Erro");
            }

            task.setDescricao(task.getDescricao());
            task.setStatus(task.getStatus());
            task.setUsuario(task.getUsuario());
            task.setObservacao(task.getObservacao());
            task.setPrioridade(task.getPrioridade());

            taskService.editarTaskService(task, id);
        } catch (Exception e) {
            System.err.println("Erro ao editar task: " + e.getMessage());
        }
    }

    @PUT
    @Path("/{id}/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarUsuarioDaTarefaService(@PathParam("id") Integer id, Usuario novoUsuario) {
        try {
            taskService.alterarUsuarioDaTarefaService(id, novoUsuario);
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao alterar o usuário da tarefa: " + e.getMessage(), 500);
        }
    }

    @POST
    @Path("/historico")
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarHistoricoService(Task task, String descricao) {
        try {
            taskService.adicionarHistoricoService(task, descricao);
        } catch (Exception e) {
            System.err.println("Erro ao registrar histórico: " + e.getMessage());
        }
    }
}
