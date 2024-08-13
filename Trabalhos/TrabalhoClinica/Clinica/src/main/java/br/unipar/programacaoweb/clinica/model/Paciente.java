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

// Entidade representando um paciente
@Entity
@Getter
@Setter
@Tag(name = "Modelo do Paciente", description = "Paciente")
public class Paciente implements Serializable {

    // Identificador do paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do paciente")
    private Integer id;

    // Nome do paciente
    @Schema(description = "Nome do paciente")
    private String nome;

    // Telefone do paciente
    @Schema(description = "Telefone do paciente")
    private String telefone;

    // Data de nascimento do paciente
    @Schema(description = "Data de nascimento do paciente")
    private String dataNascimento;

    // Plano de saúde do paciente
    @Schema(description = "Plano de saúde do paciente")
    private String plano;
}
