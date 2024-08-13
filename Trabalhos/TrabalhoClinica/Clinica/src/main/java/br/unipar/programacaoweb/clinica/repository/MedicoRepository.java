package br.unipar.programacaoweb.clinica.repository;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Medico;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade Médico
@Repository
@Tag(name = "Repositório de Médico", description = "Médico")
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
