package com.pdv.vendas.services.util.mapper;

import com.pdv.vendas.model.Cliente;
import com.pdv.vendas.model.Venda;
import com.pdv.vendas.services.dto.venda.VendaCreateDto;
import com.pdv.vendas.services.dto.venda.VendaDto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T22:37:43-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class VendaMapperImpl implements VendaMapper {

    @Override
    public Venda toEntity(VendaCreateDto vendaCreateDto) {
        if ( vendaCreateDto == null ) {
            return null;
        }

        Venda venda = new Venda();

        venda.setObservacoes( vendaCreateDto.observacoes() );

        return venda;
    }

    @Override
    public VendaDto toDto(Venda venda) {
        if ( venda == null ) {
            return null;
        }

        Long clienteId = null;
        Long id = null;
        String observacoes = null;
        Date dataVenda = null;
        BigDecimal total = null;

        clienteId = vendaClienteId( venda );
        id = venda.getId();
        observacoes = venda.getObservacoes();
        dataVenda = venda.getDataVenda();
        total = venda.getTotal();

        VendaDto vendaDto = new VendaDto( id, clienteId, observacoes, dataVenda, total );

        return vendaDto;
    }

    private Long vendaClienteId(Venda venda) {
        if ( venda == null ) {
            return null;
        }
        Cliente cliente = venda.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Long id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
