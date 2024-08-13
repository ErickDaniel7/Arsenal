package br.unipar.programacaoweb.;

// Importações necessárias
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Classe principal da aplicação
@SpringBootApplication
@Tag(name = "Classe principal", description = "Main")
public class Clinica2Application {

    // Método principal, inicia a aplicação Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Clinica2Application.class, args);
    }
}
