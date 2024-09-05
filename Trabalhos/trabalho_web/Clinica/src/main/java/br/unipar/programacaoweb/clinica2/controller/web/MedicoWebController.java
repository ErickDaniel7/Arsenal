package br.unipar.programacaoweb.clinica2.controller.web;

import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicoWebController {

    private final MedicoService medicoService;

    public MedicoWebController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/medico")
    private String getAllMedicos(Model model) {
        List<Medico> medicos = medicoService.getAll();
        model.addAttribute("medicos", medicos);
        return "medico";
    }

    @PostMapping("/medico/save")
    public String saveMedicos(Medico medico) {
        medicoService.save(medico);
        return "redirect:/medico";
    }
}
