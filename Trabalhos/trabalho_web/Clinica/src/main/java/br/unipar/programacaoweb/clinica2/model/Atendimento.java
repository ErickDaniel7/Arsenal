package br.unipar.programacaoweb.clinica2.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;

    private String anamnese;

    @ManyToOne
    @JoinColumn(name = "fk_medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_paciente_id", nullable = false)
    private Paciente paciente;
}
