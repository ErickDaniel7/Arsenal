package br.unipar.programacaoweb.apivenda.controller;


import br.unipar.programacaoweb.apivenda.model.Produto;
import br.unipar.programacaoweb.apivenda.service.ProdutoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProduto(Produto produto) {
        try {
            produtoService.cadastrarProduto(produto);
            return Response.status(201).entity("Produto Cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getProdutos() {
        try {
            return Response.ok(produtoService.getProduto())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }


}
