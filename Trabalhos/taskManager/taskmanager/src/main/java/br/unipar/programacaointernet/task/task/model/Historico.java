package br.unipar.programacaointernet.task.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column
    private LocalDate dataDeAlteracao;

    @Column
    private String observacao;

    @Column
    private String prioridade;

    @Column
    private String status;

    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;

    @JoinColumn(name = "fk_task_id")
    private Task task;
}
