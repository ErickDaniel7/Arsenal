package br.unipar.programacaoweb.clinica2.controller.web;

import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginWebController {

    private final UsuarioService usuarioService;

    public LoginWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Retorna a página de login (login.html)
    }

//    @GetMapping("/hello-world")
//    public String helloWorld(@RequestParam(value = "name", defaultValue = "World")
//                             String name) {
//        return "Hello " + name + "!";
//    }

    @GetMapping("/hello-world/{name}")
    public String helloWorld(@PathVariable(value = "name") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/telaGeral")
    public String telaGeral() {
        return "telaGeral";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {

        Usuario usuario = usuarioService.validarUsuario(username, password);
        if(usuario != null) {
            //se nosso usuario tiver válido
            session.setAttribute("usuarioLogado", username);
            return "redirect:/telaGeral";
        } else {
            model.addAttribute("erro",
                    "Usuário ou senha inválidos");
            return "login";
        }
    }
}
