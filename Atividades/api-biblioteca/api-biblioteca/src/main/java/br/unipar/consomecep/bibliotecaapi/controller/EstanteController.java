package br.unipar.consomecep.bibliotecaapi.controller;

import br.unipar.consomecep.bibliotecaapi.model.Estante;
import br.unipar.consomecep.bibliotecaapi.service.EstanteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estante")
public class EstanteController {

    @Inject
    private EstanteService estanteService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarEstante(Estante estante) {
        try {
            estanteService.cadastrarEstante(estante);
            return Response.status(201).entity("Estante Cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getEstantes() {
        try {
            return Response.ok(estanteService.getEstante())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }



}
