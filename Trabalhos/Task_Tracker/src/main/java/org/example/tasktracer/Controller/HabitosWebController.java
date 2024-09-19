package org.example.tasktracer.Controller;

import org.example.tasktracer.Model.Habitos;
import org.example.tasktracer.Service.HabitosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HabitosWebController {

    private final HabitosService habitosService;

    public HabitosWebController(HabitosService habitosService) {this.habitosService = habitosService;}

    @GetMapping("/taskTracer")
    public String bemVindo(){return "taskTracer";}

    @PostMapping("/salvarHabitos")
    public String salvarHabitos(Habitos habitos) {
        habitosService.save(habitos);
        return "redirect:/taskTracer";
    }
}
