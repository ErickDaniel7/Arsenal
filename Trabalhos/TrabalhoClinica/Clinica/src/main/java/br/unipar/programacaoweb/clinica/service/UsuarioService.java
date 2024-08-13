package br.unipar.programacaoweb.clinica.service;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Usuario;
import br.unipar.programacaoweb.clinica.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import java.util.List;

// Serviço para a entidade Usuario
@Service
@Tag(name = "Serviço de Usuário", description = "Usuário")
public class UsuarioService {

    // Repositório de Usuário
    private final UsuarioRepository usuarioRepository;

    // Construtor do serviço de Usuário
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Operação para obter todos os usuários cadastrados no sistema
    @Operation(summary = "Obter todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados no sistema.")
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    // Operação para salvar um novo usuário no sistema
    @Operation(summary = "Salvar usuário", description = "Salva um novo usuário no sistema.")
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    // Operação para realizar o login do usuário
    @Operation(summary = "Login do usuário", description = "Realiza o login do usuário.")
    public Usuario login(Usuario usuario) {
        List<Usuario> userArray = this.usuarioRepository.findAll();
        for (Usuario user : userArray) {
            if (user.getNome().equals(usuario.getNome()) && user.getSenha().equals(usuario.getSenha())) {
                return user;
            }
        }
        return null;
    }
}
