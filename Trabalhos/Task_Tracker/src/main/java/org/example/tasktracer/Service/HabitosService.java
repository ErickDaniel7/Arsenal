package org.example.tasktracer.Service;

import org.example.tasktracer.Model.Habitos;
import org.example.tasktracer.Repository.HabitosRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitosService {
    private final HabitosRepository habitosRepository;

    public HabitosService(HabitosRepository habitosRepository) {this.habitosRepository = habitosRepository;}

    public Habitos save(Habitos habitos){return this.habitosRepository.save(habitos);}

}
