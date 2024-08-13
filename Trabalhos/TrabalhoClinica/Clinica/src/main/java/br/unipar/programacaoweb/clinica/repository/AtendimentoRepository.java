package br.unipar.programacaoweb.clinica.repository;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Atendimento;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade de atendimento
@Repository
@Tag(name = "Repositório de Atendimento", description = "Atendimento")
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
}
