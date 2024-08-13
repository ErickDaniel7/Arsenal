package br.unipar.programacaointernet.seervicecep.servicecep.util.service;

import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UsuarioSEI {

    @WebMethod
    String boasVindas(String nome);


    String consultaUsuario(Long idUsuario);

    List<Usuario> consultaTodosUsuario();

    String deletaUsuario(Long idUsuario);

    String salvarUsuario(Usuario usuario);

    String editarUsuario(Long idUsuario, String login, String nome, String senha);
}
