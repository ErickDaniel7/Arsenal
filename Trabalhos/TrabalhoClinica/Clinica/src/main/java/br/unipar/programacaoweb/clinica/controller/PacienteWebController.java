package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Paciente;
import br.unipar.programacaoweb.clinica.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

// Controlador para a parte web relacionada aos pacientes
@Controller
@Tag(name = "Paciente Web Controller", description = "Paciente")
public class PacienteWebController {

    private final PacienteService pacienteService;

    // Injeção de dependência do serviço de pacientes
    public PacienteWebController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Operação para obter todos os pacientes cadastrados
    @Operation(summary = "Obter todos os pacientes", description = "Retorna uma lista de todos os pacientes cadastrados.")
    @GetMapping(path = "/paciente")
    public String getAllPaciente(Model model) {
        List<Paciente> paciente = pacienteService.getAll();
        model.addAttribute("paciente", paciente); // Adiciona a lista de pacientes ao modelo
        return "paciente"; // Retorna o nome da página HTML
    }

    // Operação para salvar um novo paciente
    @Operation(summary = "Salvar um paciente", description = "Salva um novo paciente no sistema.")
    @PostMapping(path = "/paciente/save")
    public String savePaciente(Paciente paciente) {
        pacienteService.save(paciente); // Salva o paciente
        return "redirect:/paciente"; // Redireciona de volta para a página de pacientes
    }
}
