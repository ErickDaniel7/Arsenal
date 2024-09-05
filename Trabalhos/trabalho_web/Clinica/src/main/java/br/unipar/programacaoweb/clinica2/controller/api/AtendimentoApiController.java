package br.unipar.programacaoweb.clinica2.controller.api;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Atendimento API", description = "API para gerenciamento de atendimentos")
public class AtendimentoApiController {

    private final AtendimentoService atendimentoService;

    public AtendimentoApiController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping("/api/atendimentos")
    @Operation(summary = "Obter todos os atendimentos", description = "Retorna uma lista de todos os atendimentos")
    public ResponseEntity<List<Atendimento>> listarAtendimento(){
        return ResponseEntity.ok(atendimentoService.getAll());
    }

    @PostMapping("/api/atendimentos")
    @Operation(summary = "Salvar atendimento",
            description = "Salva um novo atendimento e retorna o atendimento salvo",
            parameters = {
                    @Parameter(name = "atendimento", description = "Atendimento que será adicionado. " +
                            "Não é necessário incluir o ID.")
            })
    public ResponseEntity<Atendimento> salvarAtendimento(@RequestBody Atendimento atendimento){
        return ResponseEntity.ok(atendimentoService.save(atendimento));
    }
}
