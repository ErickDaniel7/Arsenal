package org.example.tasktracer.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private Timestamp data_inicio;

    private Timestamp data_limite;

    private Boolean concluida;

    @ManyToOne
    private Usuario usuario;
}
