package br.unipar.consomecep.bibliotecaapi.service;

import br.unipar.consomecep.bibliotecaapi.model.Usuario;
import br.unipar.consomecep.bibliotecaapi.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    public void cadastrarUsuario(Usuario user) throws Exception {
        usuarioRepository.cadastrarUsuario(user);
    }

    public List<Usuario> getUsuarios(){
        return  usuarioRepository.getUsuarios();
    }

    public  void updateUsuario(Usuario user ){
        usuarioRepository.updateUsuario(user);
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteUsuario(id);
    }


}
}
