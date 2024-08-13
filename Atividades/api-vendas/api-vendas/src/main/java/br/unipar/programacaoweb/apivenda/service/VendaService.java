package br.unipar.programacaoweb.apivenda.service;



import br.unipar.programacaoweb.apivenda.model.Venda;
import br.unipar.programacaoweb.apivenda.repository.VendaRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {

    @Inject
    private VendaRepository vendaRepository;

    public void cadastrarVenda(Venda venda) throws Exception {
        vendaRepository.cadastrarVenda(venda);
    }

    public List<Venda> getVenda() {
        return vendaRepository.getVendas();
    }


}
