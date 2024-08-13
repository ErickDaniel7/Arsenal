package br.unipar.programacaoweb.clinica.repository;

// Importações necessárias
import br.unipar.programacaoweb.clinica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade de Usuário
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
