package br.unipar.programacaoweb.clinica.model;

// Importações necessárias
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

// Entidade representando um médico
@Entity
@Getter
@Setter
@Tag(name = "Modelo do Médico", description = "Médico")
public class Medico implements Serializable {

    // Identificador do médico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do médico")
    private Integer id;

    // Nome do médico
    @Schema(description = "Nome do médico")
    private String nome;

    // Especialidade do médico
    @Schema(description = "Especialidade do médico")
    private String especialidade;
}
