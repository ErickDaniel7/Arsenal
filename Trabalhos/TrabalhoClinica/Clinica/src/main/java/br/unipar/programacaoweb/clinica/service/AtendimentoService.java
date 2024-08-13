package br.unipar.programacaoweb.clinica.service;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Atendimento;
import br.unipar.programacaoweb.clinica.repository.AtendimentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import java.util.List;

// Serviço para a entidade de Atendimento
@Service
@Tag(name = "Serviço de Atendimento", description = "Atendimento")
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    // Construtor do serviço de Atendimento
    public AtendimentoService(AtendimentoRepository atendimentoRepository){
        this.atendimentoRepository = atendimentoRepository;
    }

    // Operação para obter todos os atendimentos disponíveis
    @Operation(summary = "Obter todos os atendimentos", description = "Retorna uma lista de todos os atendimentos disponíveis.")
    public List<Atendimento> getAll(){
        return this.atendimentoRepository.findAll();
    }

    // Operação para salvar um novo atendimento no sistema
    @Operation(summary = "Salvar atendimento", description = "Salva um novo atendimento no sistema.")
    public Atendimento save(Atendimento atendimento){
        return this.atendimentoRepository.save(atendimento);
    }
}
