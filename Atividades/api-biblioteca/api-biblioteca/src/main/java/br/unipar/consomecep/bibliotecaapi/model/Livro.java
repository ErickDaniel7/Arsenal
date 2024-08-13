package br.unipar.consomecep.bibliotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String titulo;

    @Column(length = 120)
    private String autor;

    @Column(length = 60)
    private String arquivoPdf;

    @Column(length = 3)
    private String classificacaoEtaria;

    @Column(length = 20)
    private Boolean emLeitura;
}
