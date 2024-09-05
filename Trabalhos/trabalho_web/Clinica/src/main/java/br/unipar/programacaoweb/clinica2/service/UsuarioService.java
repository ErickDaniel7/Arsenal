package br.unipar.programacaoweb.clinica2.service;

import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario validarUsuario(String login, String senha) {
        return this.usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Usuario validarAdmin(String login) {
        return this.usuarioRepository.findByLogin(login);
    }
}
