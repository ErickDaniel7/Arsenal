package br.unipar.programacaoweb.apivenda.service;

import br.unipar.programacaoweb.apivenda.model.Cliente;
import br.unipar.programacaoweb.apivenda.repository.ClienteRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless

public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente) throws Exception {
        clienteRepository.cadastrarCliente(cliente);
    }

    public List<Cliente> getCliente() {
        return clienteRepository.getClientes();
    }


}
