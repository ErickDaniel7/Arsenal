package org.example.tasktracer.Service;

import org.example.tasktracer.Model.Tarefas;
import org.example.tasktracer.Repository.TarefasRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {

    private final TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository) {this.tarefasRepository = tarefasRepository;}

    public Tarefas salvarTarefas(Tarefas tarefas){return this.tarefasRepository.save(tarefas);}
}
