package org.example.tasktracer.Repository;

import org.example.tasktracer.Model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {
}
