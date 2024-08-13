package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Paciente;
import br.unipar.programacaoweb.clinica.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Controlador para a API de pacientes
@RestController
@Tag(name = "Paciente API Controller", description = "Paciente")
public class PacienteApiController {

    private final PacienteService pacienteService;

    // Injeção de dependência do serviço de pacientes
    public PacienteApiController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Operação para obter todos os pacientes cadastrados
    @Operation(summary = "Obter todos os pacientes", description = "Retorna uma lista de todos os pacientes cadastrados.")
    @GetMapping(path = "/api/paciente")
    public ResponseEntity<List<Paciente>> getAll() {
        return ResponseEntity.ok(pacienteService.getAll());
    }

    // Operação para salvar um novo paciente
    @Operation(summary = "Salvar um paciente", description = "Salva um novo paciente no sistema.")
    @PostMapping(path = "/api/paciente")
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.save(paciente));
    }
}
