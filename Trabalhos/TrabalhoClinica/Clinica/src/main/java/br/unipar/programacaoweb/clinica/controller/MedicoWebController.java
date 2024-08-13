package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Medico;
import br.unipar.programacaoweb.clinica.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

// Controlador para a parte web relacionada aos médicos
@Controller
@Tag(name = "Medico Web Controller", description = "Medico")
public class MedicoWebController {

    private final MedicoService medicoService;

    // Injeção de dependência do serviço de médicos
    public MedicoWebController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Operação para obter todos os médicos cadastrados
    @Operation(summary = "Obter todos os médicos", description = "Retorna uma lista de todos os médicos cadastrados.")
    @GetMapping(path = "/medico")
    public String getAllMedico(Model model) {
        List<Medico> medico = medicoService.getAll();
        model.addAttribute("medico", medico); // Adiciona a lista de médicos ao modelo
        return "medico"; // Retorna o nome da página HTML
    }

    // Operação para salvar um novo médico
    @Operation(summary = "Salvar um médico", description = "Salva um novo médico no sistema.")
    @PostMapping(path = "/medico/save")
    public String saveUsuario(Medico medico) {
        medicoService.save(medico); // Salva o médico
        return "redirect:/medico"; // Redireciona de volta para a página de médicos
    }
}
