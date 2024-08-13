package br.unipar.programacaointernet.seervicecep.servicecep.util.dao;

import br.unipar.programacaointernet.seervicecep.servicecep.util.model.Endereco;

import java.util.List;

public interface EnderecoDAO {

    void save(Endereco endereco);
    void update (Endereco endereco);
    void delete (Endereco endereco);
    public Endereco consultaCep(String cep);
    Endereco findById(long id);
    List<Endereco> findAll ();
}
