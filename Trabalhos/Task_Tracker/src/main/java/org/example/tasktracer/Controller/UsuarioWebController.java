package org.example.tasktracer.Controller;

import org.example.tasktracer.Model.Usuario;
import org.example.tasktracer.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    public UsuarioWebController(UsuarioService usuarioService) {this.usuarioService = usuarioService;}

    @GetMapping("/login")
    public String login(){return "login";}

    @PostMapping("/cadastrarUsuario")
    public String salvarUsuario(Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/taskTracer";
    }

    @GetMapping("/verificarLogin")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha){
        Usuario usuario = usuarioService.getByLogin(email, senha);
        if(usuario != null){
            return "redirect:/taskTracer";
        }else{
            return "redirect:/login";
        }
    }
}
