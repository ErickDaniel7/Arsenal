package com.pdv.vendas.services.util.mapper;

import com.pdv.vendas.model.Cliente;
import com.pdv.vendas.services.dto.cliente.ClienteCreateDto;
import com.pdv.vendas.services.dto.cliente.ClienteDto;
import com.pdv.vendas.services.dto.cliente.ClienteUpdateDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T11:36:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDto clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDTO.id() );
        cliente.setNome( clienteDTO.nome() );
        cliente.setEmail( clienteDTO.email() );
        cliente.setTelefone( clienteDTO.telefone() );

        return cliente;
    }

    @Override
    public Cliente toEntity(ClienteUpdateDto clienteUpdateDto) {
        if ( clienteUpdateDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteUpdateDto.id() );
        cliente.setNome( clienteUpdateDto.nome() );
        cliente.setEmail( clienteUpdateDto.email() );
        cliente.setTelefone( clienteUpdateDto.telefone() );

        return cliente;
    }

    @Override
    public Cliente toEntity(ClienteCreateDto clienteCreateDto) {
        if ( clienteCreateDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNome( clienteCreateDto.nome() );
        cliente.setEmail( clienteCreateDto.email() );
        cliente.setTelefone( clienteCreateDto.telefone() );

        return cliente;
    }

    @Override
    public ClienteDto toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;
        String telefone = null;

        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
        telefone = cliente.getTelefone();

        ClienteDto clienteDto = new ClienteDto( id, nome, email, telefone );

        return clienteDto;
    }
}
