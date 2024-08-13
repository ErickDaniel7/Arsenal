package br.unipar.programacaoweb.clinica.service;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Paciente;
import br.unipar.programacaoweb.clinica.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import java.util.List;

// Serviço para a entidade Paciente
@Service
@Tag(name = "Serviço de Paciente", description = "Paciente")
public class PacienteService {

    // Repositório de Paciente
    private final PacienteRepository pacienteRepository;

    // Construtor do serviço de Paciente
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    // Operação para obter todos os pacientes cadastrados no sistema
    @Operation(summary = "Obter todos os pacientes", description = "Retorna uma lista de todos os pacientes cadastrados no sistema.")
    public List<Paciente> getAll(){
        return this.pacienteRepository.findAll();
    }

    // Operação para salvar um novo paciente no sistema
    @Operation(summary = "Salvar paciente", description = "Salva um novo paciente no sistema.")
    public Paciente save(Paciente paciente){
        return this.pacienteRepository.save(paciente);
    }
}
