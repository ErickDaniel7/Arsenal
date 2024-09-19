package org.example.tasktracer.Service;

import org.example.tasktracer.Model.Usuario;
import org.example.tasktracer.Repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuariosRepository usuariosRepository;

    public UsuarioService(UsuariosRepository usuariosRepository) {this.usuariosRepository = usuariosRepository;}

    public Usuario salvarUsuario(Usuario usuario){return this.usuariosRepository.save(usuario);}

    public Usuario getByLogin(String email, String senha){return this.usuariosRepository.getByEmailAndSenha(email, senha);}

}
