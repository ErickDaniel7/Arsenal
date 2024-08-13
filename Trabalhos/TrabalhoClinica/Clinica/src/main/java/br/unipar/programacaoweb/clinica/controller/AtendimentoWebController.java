package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.*;
import br.unipar.programacaoweb.clinica.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

// Controlador para as operações web relacionadas aos Atendimentos
@Controller
@Tag(name = "Atendimento Web Controller", description = "Atendimentos")
public class AtendimentoWebController {

    // Serviços necessários para manipulação de Atendimentos, Médicos e Pacientes
    private final AtendimentoService atendimentoService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    // Construtor para injetar os serviços necessários
    public AtendimentoWebController(AtendimentoService atendimentoService, MedicoService medicoService, PacienteService pacienteService) {
        this.atendimentoService = atendimentoService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    // Operação para obter todos os atendimentos e preparar dados para a visão "atendimento"
    @Operation(summary = "Obter todos os atendimentos", description = "Retorna uma lista com todos os atendimentos cadastrados.")
    @GetMapping(path = "/atendimento")
    public String getAllAtendimento(Model model) {
        // Obtém todos os Atendimentos, Médicos e Pacientes
        List<Atendimento> atendimento = atendimentoService.getAll();
        List<Medico> medicos = medicoService.getAll();
        List<Paciente> pacientes = pacienteService.getAll();

        // Adiciona os dados ao modelo para a visão
        model.addAttribute("atendimento", atendimento);
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);

        // Retorna o nome da visão "atendimento"
        return "atendimento";
    }

    // Operação para salvar um novo atendimento e redirecionar para "/atendimento"
    @Operation(summary = "Salvar um novo atendimento", description = "Salva um novo atendimento no sistema.")
    @PostMapping(path = "/atendimento/save")
    public String saveAtendimento(Atendimento atendimento) {
        System.out.println("Detalhes do Atendimento: " + atendimento); // Registro informativo

        // Salva o novo atendimento
        atendimentoService.save(atendimento);

        // Redireciona para "/atendimento"
        return "redirect:/atendimento";
    }
}
