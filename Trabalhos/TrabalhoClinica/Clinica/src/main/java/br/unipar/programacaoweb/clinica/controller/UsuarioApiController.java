package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Usuario;
import br.unipar.programacaoweb.clinica.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Controlador para a API de usuários
@RestController
@Tag(name = "Usuario API Controller", description = "Usuario")
public class UsuarioApiController {

    private final UsuarioService usuarioService;

    // Injeção de dependência do serviço de usuários
    public UsuarioApiController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Operação para obter todos os usuários cadastrados
    @Operation(summary = "Obter todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
    @GetMapping(path = "/api/usuarios")
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    // Operação para salvar um novo usuário
    @Operation(summary = "Salvar um usuário", description = "Salva um novo usuário no sistema.")
    @PostMapping(path = "/api/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
}
