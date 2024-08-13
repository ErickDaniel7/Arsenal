package br.unipar.programacaoweb.clinica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Cadastro Web Controller", description = "Cadastro")
public class CadastroWebController {

    @Operation(summary = "Página de cadastro", description = "Retorna a página de cadastro.")
    @GetMapping("/cadastro")
    public String loginAdmin(){
        return "cadastro";
    }

    public void loginHandle(){

    }
}
