package br.unipar.programacaoweb.clinica2.repository;

import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
