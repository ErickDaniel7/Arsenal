package br.unipar.programacaoweb.clinica2.controller.api;
import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.repository.PacienteRepository;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.hibernate.service.spi.InjectService;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Médico API", description = "API para gerenciamento de médicos")
public class MedicoApiController {
    private final MedicoService medicoService;

    public MedicoApiController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/api/medicos")
    @Operation(summary = "Obter todos os médicos", description = "Retorna uma lista de todos os médicos")
    public ResponseEntity<List<Medico>> listarMedico(){
        return ResponseEntity.ok(medicoService.getAll());
    }

    @PostMapping("/api/medicos")
    @Operation(summary = "Salvar médico",
            description = "Salva um novo médico e retorna o médico salvo",
            parameters = {
                    @Parameter(name = "medico", description = "Médico que será adicionado. " +
                            "Não é necessário incluir o ID.")
            })
    public ResponseEntity<Medico> salvarMedico(@RequestBody Medico medico){
        return ResponseEntity.ok(medicoService.save(medico));
    }
}
