package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.listarTodos();
    }


    public void cadastrarService(Usuario usuario) throws Exception {
        usuarioRepository.cadastrar(usuario);
    }

    public Usuario buscarPorIdService(Integer id) {
        usuarioRepository.buscaPorID(id);
        return null;
    }

    public void deletarUsuarioService(Integer id) throws Exception {
        usuarioRepository.excluirUsuario(id);
    }

    public void editarUsuarioService(Integer id) throws Exception {
        usuarioRepository.editarUsuario(id);
    }
}
