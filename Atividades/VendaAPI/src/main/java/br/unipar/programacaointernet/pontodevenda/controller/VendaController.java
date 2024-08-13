package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

@Path("/venda")
public class VendaController {


  @Inject
  private VendaService vendaService;

  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarVendas() {

    return Response.ok(vendaService.listar())
            .build();
  }

  @GET
  @Path("/vendaTotal")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarVendaTotal() {
    return Response.ok(vendaService.listarVendaTotal()).build();
  }

  @GET
  @Path("/vendaQuantidade")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarVendaQuantidade() {
    return Response.ok(vendaService.listarVendaQuantidade()).build();
  }


  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Response listarVendaPorID(@PathParam("id") Integer id) {
    Venda venda = vendaService.buscarPorID(id);
    if(venda == null)
      return Response.status(204).entity("Venda não encontrada").build();

    return Response.ok(venda).build();
  }

  @GET
  @Path("/total")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarVendasPorValorTotal(@QueryParam("total") BigDecimal total) {
    List<Venda> vendas = vendaService.listarPorValorTotal(total);
    if(vendas.isEmpty())
      return Response.status(204).entity("Nenhuma venda encontrada com o valor total especificado").build();

    return Response.ok(vendas).build();
  }


  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response cadastrarVenda(Venda venda) {
    try {
      vendaService.cadastrar(venda);
      return Response.status(201)
              .entity(venda)
              .build();
    } catch (Exception ex) {
      return Response.status(403).entity(ex.getMessage()).build();
    }
  }

  @PUT
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response editarVenda(Venda venda) {
    try {
      vendaService.editar(venda);
      return Response.status(200)
              .entity(venda)
              .build();
    } catch (Exception ex) {
      return Response.status(403).entity(ex.getMessage()).build();
    }
  }

  @DELETE
  @Path("/{id}")
  public Response excluirVenda(@PathParam("id") Integer id) {
    try {
      Venda venda = vendaService.buscarPorID(id);
      if (venda == null) {
        return Response.status(204).entity("Venda não encontrado").build();
      }
      vendaService.excluir(venda);
      return Response.status(200)
              .entity("Venda excluído com sucesso!")
              .build();
    } catch (Exception ex) {
      return Response.status(403).entity(ex.getMessage()).build();
    }
  }
}
