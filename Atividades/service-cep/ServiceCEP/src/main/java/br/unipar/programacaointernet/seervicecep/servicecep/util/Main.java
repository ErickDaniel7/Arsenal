package br.unipar.programacaointernet.seervicecep.servicecep.util;

import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.EnderecoDAO;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.UsuarioDAO;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            EntityManagerUtil.getEntityManagerFactory();

            //salvarUsuario();
            //editarUsuario();
            //deletarUsuario();
            //busacarTodosUsuario();
            salvarEndereco();

            EntityManagerUtil.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void salvarUsuario() {
        UsuarioDAO usuarioDao = new UsuarioDAOImpl(
                EntityManagerUtil.getManager());

        Usuario usuario = new Usuario();

        usuario.setNome("Renan Augusto");
        usuario.setLogin("Renan123");
        usuario.setSenha("102536");

        usuarioDao.save(usuario);
    }

    private static void editarUsuario() {
        UsuarioDAO usuarioDao = new UsuarioDAOImpl(
                EntityManagerUtil.getManager());

        Usuario usuario = usuarioDao.findById(1L);

        usuario.setSenha("102536");

        usuarioDao.update(usuario);
    }

    private static void deletarUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAOImpl(
                EntityManagerUtil.getManager());

        Usuario usuario = usuarioDao.findById(2L);

        System.out.println("Usuário encontrado " + usuario.getNome() + " com sucesso");
    }

    private static void busacarTodosUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAOImpl(
                EntityManagerUtil.getManager());

        List<Usuario> usuarios = usuarioDao.findAll();

        for (Usuario u : usuarios){
            System.out.println("Usuário " + u.getNome()+ " encontrado com sucesso!");

        }
    }

    private static void salvarEndereco(){
        try{
            EnderecoDAO enderecoDao =
                    new EnderecoDAOImpl(EntityManagerUtil.getManager());

            enderecoDao.save(getViaCep("85816300"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private static Endereco getViaCep(String cep) throws Exception{
        URL url = new URL("http://viacep.com.br/ws/"
                +cep.replace("-", "")
                .replace(".", "")
                +"/xml/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += inputLine;

        in.close();
        //  return result;
        Endereco objCep = new Endereco();
        objCep = Endereco.unmarshalFromString(result);

        return objCep;
    }
}
