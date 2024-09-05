package br.unipar.programacaoweb.clinica2.repository;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento,Integer> {
}
