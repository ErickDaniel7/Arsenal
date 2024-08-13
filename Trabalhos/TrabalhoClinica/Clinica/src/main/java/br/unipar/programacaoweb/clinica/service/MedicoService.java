package br.unipar.programacaoweb.clinica.service;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Medico;
import br.unipar.programacaoweb..repository.MedicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import java.util.List;

// Serviço para a entidade Médico
@Service
@Tag(name = "Serviço de Médico", description = "Médico")
public class MedicoService {

    // Repositório de Médico
    private final MedicoRepository medicoRepository;

    // Construtor do serviço de Médico
    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    // Operação para listar todos os médicos cadastrados no sistema
    @Operation(summary = "Listar todos os médicos", description = "Recupera uma lista contendo todos os médicos cadastrados no sistema.")
    public List<Medico> getAll(){
        return this.medicoRepository.findAll();
    }

    // Operação para salvar um novo médico no sistema
    @Operation(summary = "Salvar médico", description = "Salva um novo médico no sistema.")
    public Medico save(Medico medico){
        return this.medicoRepository.save(medico);
    }
}
