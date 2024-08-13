package br.unipar.programacaointernet.seervicecep.servicecep.util.service;

import br.unipar.programacaointernet.seervicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.UsuarioDAO;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Usuario;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "br.unipar.programacaointernet.seervicecep.servicecep.util.service.UsuarioSEI")
public class UsuarioSIB  implements UsuarioSEI {

    @Override
    public String boasVindas(String nome) {
        return "Bem vndo" + nome + "!";
    }

    @Override
    public String consultaUsuario (Long idUsuario){
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );
        Usuario usuario = usuarioDAO.findById(idUsuario);

        return "Usuário retornado " + usuario.getNome();
    }

    @Override
    public List<Usuario> consultaTodosUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        return usuarioDAO.findAll();
    }

    @Override
    public String deletaUsuario(Long idUsuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        Usuario a = usuarioDAO.findById(idUsuario);

        usuarioDAO.delete(a);

        return "usuário deletado com sucesso!" + a.getNome();
    }

    @Override
    public String salvarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        usuarioDAO.save(usuario);

        return "Usuário salvo com sucesso!";
    }

    @Override
    public String editarUsuario(Long idUsuario, String login, String nome, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        Usuario a = usuarioDAO.findById(idUsuario);

        if (login != null) {
            a.setLogin(login);
        }

        if (senha != null) {
            a.setSenha(senha);
        }

        if (nome != null) {
            a.setNome(nome);
        }

        usuarioDAO.update(a);

        return "Usuário editado com sucesso!";
    }

}