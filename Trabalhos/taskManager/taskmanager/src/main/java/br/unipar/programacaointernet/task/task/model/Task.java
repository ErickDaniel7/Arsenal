package br.unipar.programacaointernet.task.task.model;

import jakarta.ejb.Local;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column
    private String observacao;

    @Column
    private LocalDate dataDePrevisao;

    @Column
    private String prioridade;

    @Column
    private String status;

    @Column
    private LocalDate dataDeInicio;

    @Column
    private LocalDate dataDeTermino;

    @Column
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;


}
