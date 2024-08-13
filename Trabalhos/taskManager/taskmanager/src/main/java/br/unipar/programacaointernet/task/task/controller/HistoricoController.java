package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Historico;
import br.unipar.programacaointernet.task.task.repository.HistoricoRepository;
import br.unipar.programacaointernet.task.task.service.HistoricoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/historicos")
public class HistoricoController {

    @Inject
    private HistoricoRepository historicoRepository;
    @Inject
    private HistoricoService historicoService;
    //Repository
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Historico> listarHistoricos() {
        return historicoRepository.listarHistoricos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Historico buscarPorId(@PathParam("id") Integer id) {
        return historicoRepository.buscarPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrar(Historico historico) throws Exception {
        historicoRepository.cadastrar(historico);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Integer id) throws Exception {
        historicoRepository.excluir(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Historico historico, @PathParam("id") Integer id) throws Exception {
        historicoRepository.editar(historico, id);
    }
    //Service
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Historico> listarHistoricosService() {
        return historicoService.listarHistoricosService();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Historico buscaPorIdService(@PathParam("id") Integer id) {
        return historicoService.buscaPorIdService(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastroService(Historico historico) throws Exception {
        historicoService.cadastroService(historico);
    }

    @DELETE
    @Path("/{id}")
    public void excluirService(@PathParam("id") Integer id) throws Exception {
        historicoService.excluirService(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarService(Historico historico, @PathParam("id") Integer id) throws Exception {
        historicoService.editarService(historico, id);
    }
}
