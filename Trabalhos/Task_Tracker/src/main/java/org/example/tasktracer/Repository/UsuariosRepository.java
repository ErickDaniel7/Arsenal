package org.example.tasktracer.Repository;

import org.example.tasktracer.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Usuario getByEmailAndSenha(String senha, String email);
}
