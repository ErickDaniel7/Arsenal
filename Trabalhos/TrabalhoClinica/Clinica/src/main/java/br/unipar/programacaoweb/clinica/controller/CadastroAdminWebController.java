package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;

// Controlador para a página de cadastro de administrador
@Controller
@Tag(name = "Login Web Controller", description = "Login")
public class CadastroAdminWebController {

    // Operação para exibir uma mensagem de hello world
    @Operation(summary = "Exibe uma mensagem de hello world", description = "Retorna uma mensagem de saudação com o nome especificado.")
    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }

    // Operação para retornar a página de cadastro de administrador
    @Operation(summary = "Página de cadastro de administrador", description = "Retorna a página de cadastro de administrador.")
    @GetMapping("/cadastroAdmin")
    public String loginAdmin() {
        return "cadastroAdmin"; // Retorna o nome da página HTML
    }

    // Método vazio para lidar com o login
    public void loginHandle() {
        // Este método pode ser usado para lidar com a lógica de login, se necessário
    }
}
