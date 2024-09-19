package org.example.tasktracer.Controller;

import org.example.tasktracer.Model.Tarefas;
import org.example.tasktracer.Model.Usuario;
import org.example.tasktracer.Service.TarefasService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Controller
public class TarefasWebController {

    private final TarefasService tarefasService;

    public TarefasWebController(TarefasService tarefasService) {this.tarefasService = tarefasService;}

    @PostMapping("/cadastrarTarefas")
    public String salvarUsuario() {
        Tarefas tarefas = new Tarefas();
        tarefas.setData_inicio(Timestamp.from(Instant.now()));
        tarefasService.salvarTarefas(tarefas);
        return "redirect:/taskTracer";
    }
}
