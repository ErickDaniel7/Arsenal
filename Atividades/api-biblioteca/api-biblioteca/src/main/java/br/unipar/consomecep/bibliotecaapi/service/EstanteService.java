package br.unipar.consomecep.bibliotecaapi.service;

import br.unipar.consomecep.bibliotecaapi.model.Estante;
import br.unipar.consomecep.bibliotecaapi.repository.EstanteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class EstanteService {

    @Inject
    private EstanteRepository estanteRepository;

    public void cadastrarEstante(Estante estante) throws Exception {
        estanteRepository.cadastrarEstante(estante);
    }

    public List<Estante> getEstante() {
        return estanteRepository.getEstantes();
    }


}
