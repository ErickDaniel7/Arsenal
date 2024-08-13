package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Usuario;
import br.unipar.programacaoweb.clinica.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

// Controlador para a parte web relacionada aos usuários
@Controller
@Tag(name = "Usuario Web Controller", description = "Usuario")
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    // Injeção de dependência do serviço de usuários
    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Operação para obter todos os usuários cadastrados
    @Operation(summary = "Obter todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
    @GetMapping(path = "/usuarios")
    public String getAllUsuario(Model model) {
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios); // Adiciona a lista de usuários ao modelo
        return "usuarios"; // Retorna o nome da página HTML
    }

    // Operação para salvar um novo usuário
    @Operation(summary = "Salvar um usuário", description = "Salva um novo usuário no sistema.")
    @PostMapping(path = "/usuarios/save")
    public String saveUsuario(Usuario usuario) {
        usuarioService.save(usuario); // Salva o usuário
        return "redirect:/usuarios"; // Redireciona de volta para a página de usuários
    }

    // Operação para realizar login
    @Operation(summary = "Realizar login", description = "Efetua login de um usuário no sistema.")
    @PostMapping(path = "/usuarios/login")
    public String login(Usuario usuario) {
        Usuario user = usuarioService.login(usuario);
        System.out.println(user);
        if (user != null) {
            if(user.getAdmin() != null){
                return "redirect:/cadastroAdmin"; // Redireciona para a página de cadastro de administrador
            }else{
                return "redirect:/cadastro"; // Redireciona para a página de cadastro
            }
        } else {
            return "redirect:/login"; // Redireciona para a página de login
        }
    }
}
