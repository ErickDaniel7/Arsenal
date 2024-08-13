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

// Entidade representando um usuário do sistema
@Entity
@Getter
@Setter
@Tag(name = "Modelo do Usuário", description = "Usuário")
public class Usuario implements Serializable {

    // Identificador do usuário
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário")
    private Integer id;

    // Nome do usuário
    @Schema(description = "Nome do usuário")
    private String nome;

    // Login do usuário
    @Schema(description = "Login do usuário")
    private String login;

    // Senha do usuário
    @Schema(description = "Senha do usuário")
    private String senha;

    // Indica se o usuário é um administrador
    @Schema(description = "Indica se o usuário é um administrador")
    private Boolean admin;
}
