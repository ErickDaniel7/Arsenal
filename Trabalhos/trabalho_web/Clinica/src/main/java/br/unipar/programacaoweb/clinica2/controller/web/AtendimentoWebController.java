package br.unipar.programacaoweb.clinica2.controller.web;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.service.AtendimentoService;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AtendimentoWebController {

    private final AtendimentoService atendimentoService;

    private final UsuarioService usuarioService;

    private final MedicoService medicoService;

    private final PacienteService pacienteService;

    public AtendimentoWebController(AtendimentoService atendimentoService, MedicoService medicoService, PacienteService pacienteService, UsuarioService usuarioService) {
        this.atendimentoService = atendimentoService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
        }

    @GetMapping("/atendimento")
    private String getAllAtendimentos(Model model, HttpSession session) {

        String usuarioLogado = session.getAttribute("usuarioLogado").toString();

        Usuario usuario = usuarioService.validarAdmin(usuarioLogado);

        if (usuario.isAdmin()) {
            List<Atendimento> atendimentos = atendimentoService.getAll();
            List<Medico> medicos = medicoService.getAll();
            List<Paciente> pacientes = pacienteService.getAll();

            model.addAttribute("atendimentos", atendimentos);
            model.addAttribute("medicos", medicos);
            model.addAttribute("pacientes", pacientes);

            return "atendimento";
        } else {
            model.addAttribute("erro",
                    "Usuário não tem permissão para acessar essa tela."
            );
            return "telaGeral";
        }

    }

    @PostMapping("/atendimento/save")
    public String saveAtendimentos(Atendimento atendimento) {
        atendimentoService.save(atendimento);
        return "redirect:/atendimento";
    }
}
