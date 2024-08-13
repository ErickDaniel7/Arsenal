package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.UsuarioRepository;
import br.unipar.programacaointernet.task.task.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/usuarios")
public class UsuarioController {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarPorId(@PathParam("id") Integer id) {
        return usuarioRepository.buscaPorID(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrar(Usuario usuario) throws Exception {
        usuarioRepository.cadastrar(usuario);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Integer id) throws Exception {
        usuarioRepository.excluirUsuario(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Usuario usuario, @PathParam("id") Integer id) throws Exception {
        usuarioRepository.editarUsuario(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuariosService() {
        return usuarioService.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarPorIdService(@PathParam("id") Integer id) {
        return usuarioService.buscarPorIdService(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarService(Usuario usuario) throws Exception {
        usuarioService.cadastrarService(usuario);
    }

    @DELETE
    @Path("/{id}")
    public void deletarUsuarioService(@PathParam("id") Integer id) throws Exception {
        usuarioService.deletarUsuarioService(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarUsuarioService(Usuario usuario, @PathParam("id") Integer id) throws Exception {
        usuarioService.editarUsuarioService(id);
    }
}
