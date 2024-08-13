package com.pdv.vendas.services.util.mapper;

import com.pdv.vendas.model.Produto;
import com.pdv.vendas.services.dto.produto.ProdutoCreateDto;
import com.pdv.vendas.services.dto.produto.ProdutoDto;
import com.pdv.vendas.services.dto.produto.ProdutoUpdateDto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T11:36:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toEntity(ProdutoDto clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setId( clienteDTO.id() );
        produto.setCategoria( clienteDTO.categoria() );
        produto.setValor( clienteDTO.valor() );
        produto.setDescricao( clienteDTO.descricao() );

        return produto;
    }

    @Override
    public Produto toEntity(ProdutoUpdateDto clienteUpdateDto) {
        if ( clienteUpdateDto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setId( clienteUpdateDto.id() );
        produto.setCategoria( clienteUpdateDto.categoria() );
        produto.setValor( clienteUpdateDto.valor() );
        produto.setDescricao( clienteUpdateDto.descricao() );

        return produto;
    }

    @Override
    public Produto toEntity(ProdutoCreateDto produtoCreateDto) {
        if ( produtoCreateDto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setCategoria( produtoCreateDto.categoria() );
        produto.setValor( produtoCreateDto.valor() );
        produto.setDescricao( produtoCreateDto.descricao() );

        return produto;
    }

    @Override
    public ProdutoDto toDto(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        Long id = null;
        String categoria = null;
        BigDecimal valor = null;
        String descricao = null;

        id = produto.getId();
        categoria = produto.getCategoria();
        valor = produto.getValor();
        descricao = produto.getDescricao();

        ProdutoDto produtoDto = new ProdutoDto( id, categoria, valor, descricao );

        return produtoDto;
    }
}
