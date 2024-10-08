package br.unipar.programacaointernet.seervicecep.servicecep.util.service;

import br.unipar.programacaointernet.seervicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.EnderecoDAO;
import br.unipar.programacaointernet.seervicecep.servicecep.util.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Endereco;
import jakarta.jws.WebService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.servicecep.util.service.EnderecoSEI")
public class EnderecoSIB implements EnderecoSEI{

    @Override
    public Endereco consultaEndereco(String cep) {
        try {
            EnderecoDAO enderecoDao = new EnderecoDAOImpl(
                    EntityManagerUtil.getManager()
            );

            Endereco endereco = enderecoDao.consultaCep(cep);

            if (endereco == null) {
                enderecoDao.save(getViaCep(cep));

                return enderecoDao.consultaCep(cep);
            } else {
                return endereco;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Endereco> consultaTodosEndereco() {
        EnderecoDAO enderecoDao = new EnderecoDAOImpl(
                EntityManagerUtil.getManager()
        );

        return enderecoDao.findAll();
    }

    @Override
    public String deletaEndereco(Long idEndereco) {
        EnderecoDAO enderecoDao = new EnderecoDAOImpl(
                EntityManagerUtil.getManager()
        );

        Endereco endereco = enderecoDao.findById(idEndereco);

        enderecoDao.delete(endereco);

        return "Endereço deletado com sucesso!";
    }

    @Override
    public String salvarEndereco(String cep) throws Exception {
        EnderecoDAO enderecoDao = new EnderecoDAOImpl(
                EntityManagerUtil.getManager()
        );

        enderecoDao.save(getViaCep(cep));

        return "Endereço salvo com sucesso!";
    }

    @Override
    public String editarEndereco(Long idEndereco, String bairro, String localidade) {
        EnderecoDAO enderecoDao = new EnderecoDAOImpl(
                EntityManagerUtil.getManager()
        );

        Endereco endereco = enderecoDao.findById(idEndereco);

        if (bairro != null) {
            endereco.setBairro(bairro);
        }

        if (localidade != null) {
            endereco.setLocalidade(localidade);
        }

        enderecoDao.update(endereco);

        return "Endereço editado com sucesso!";
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
        Endereco objEndereco;
        objEndereco = Endereco.unmarshalFromString(result);

        return objEndereco;
    }
}
