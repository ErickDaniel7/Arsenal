package br.unipar.programacaoweb.clinica.repository;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Paciente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade Paciente
@Repository
@Tag(name = "Repositório de Paciente", description = "Paciente")
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
