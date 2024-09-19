package org.example.tasktracer.Repository;

import org.example.tasktracer.Model.Habitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitosRepository extends JpaRepository<Habitos, Integer> {

}
