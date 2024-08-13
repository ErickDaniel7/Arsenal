package br.unipar.programacaoweb.clinica.model;

// Importações necessárias
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

// Classe representando um atendimento
@Entity
@Getter
@Setter
@Tag(name = "Modelo do Atendimento", description = "Atendimento")
public class Atendimento implements Serializable {

    // Identificador do atendimento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do atendimento")
    private Integer id;

    // Data e hora do atendimento
    @Schema(description = "Data e hora do atendimento")
    private String dataHora;

    // Anamnese do atendimento
    @Schema(description = "Anamnese do atendimento")
    private String anamnese ;

    // Médico responsável pelo atendimento
    @ManyToOne
    @Schema(description = "Médico responsável pelo atendimento")
    private Medico medico;

    // Paciente atendido
    @ManyToOne
    @Schema(description = "Paciente atendido")
    private Paciente paciente;
}
