package br.unipar.programacaoweb.clinica.controller;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Atendimento;
import br.unipar.programacaoweb.clinica.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Controlador para a API de Atendimento
@RestController
@Tag(name = "Controlador de API de Atendimento", description = "Atendimentos")
public class AtendimentoApiController {

    // Serviço de Atendimento
    private final AtendimentoService atendimentoService;

    // Construtor do controlador de API de Atendimento
    public AtendimentoApiController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    // Operação para obter todos os atendimentos cadastrados no sistema
    @Operation(summary = "Obter todos os atendimentos", description = "Retorna uma lista com todos os atendimentos cadastrados.")
    @GetMapping(path = "/api/atendimentos")
    public ResponseEntity<List<Atendimento>> getAll() {
        return ResponseEntity.ok(atendimentoService.getAll());
    }

    // Operação para salvar um novo atendimento no sistema
    @Operation(summary = "Salvar um novo atendimento", description = "Salva um novo atendimento no sistema.")
    @PostMapping(path = "/api/atendimentos")
    public ResponseEntity<Atendimento> save(@RequestBody Atendimento atendimento) {
        return ResponseEntity.ok(atendimentoService.save(atendimento));
    }
}
