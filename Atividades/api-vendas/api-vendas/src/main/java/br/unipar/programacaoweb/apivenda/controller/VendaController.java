package br.unipar.programacaoweb.apivenda.controller;

import br.unipar.programacaoweb.apivenda.model.Venda;
import br.unipar.programacaoweb.apivenda.service.VendaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVenda(Venda venda) {
        try {
            vendaService.cadastrarVenda(venda);
            return Response.status(201).entity("Venda cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getVendas() {
        try {
            return Response.ok(vendaService.getVendas())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
