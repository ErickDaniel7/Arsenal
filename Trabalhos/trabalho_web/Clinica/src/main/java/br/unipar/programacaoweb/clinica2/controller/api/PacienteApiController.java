package br.unipar.programacaoweb.clinica2.controller.api;

import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.repository.PacienteRepository;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Paciente API", description = "API para gerenciamento de pacientes")
public class PacienteApiController {

    private final PacienteService pacienteService;

    public PacienteApiController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/api/pacientes")
    @Operation(summary = "Obter todos os pacientes", description = "Retorna uma lista de todos os pacientes")
    private ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @PostMapping("/api/pacientes")
    @Operation(summary = "Salvar paciente",
            description = "Salva um novo paciente e retorna o paciente salvo",
            parameters = {
                    @Parameter(name = "paciente", description = "Paciente que será adicionado. " +
                            "Não é necessário incluir o ID.")
            })
    private ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.save(paciente));
    }
}
