package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

// Controlador para a página de login
@Controller
@Tag(name = "Login Controller", description = "Login")
public class LoginController {

    // Operação para retornar a página de login
    @Operation(summary = "Página de login", description = "Retorna a página de login.")
    @GetMapping("/login")
    public String loginForm(){
        return "login"; // Retorna o nome da página HTML
    }

    // Método vazio para lidar com o login
    public void loginHandle(){

    }
}
