package br.unipar.programacaointernet.seervicecep.servicecep.util.service;

import jakarta.xml.ws.Endpoint;

public class ServicePublisher {

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/usuario", new UsuarioSIB());
        Endpoint.publish("http://localhost:8080/endereco",
                new EnderecoSIB());

        System.out.println("Usuário E ENDEREÇO Endopoint publicado com sucesso");
    }
}
