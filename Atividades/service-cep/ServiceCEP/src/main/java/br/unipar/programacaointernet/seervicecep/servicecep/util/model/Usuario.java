package br.unipar.programacaointernet.seervicecep.servicecep.util.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(length = 60)
    private String nome;

    @Column(length = 20,nullable = false)
    private String login;

    @Column(length = 20,nullable = false)
    private String senha;
}
