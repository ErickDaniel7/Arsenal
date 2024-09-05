/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.crudjunitexemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author erixk
 */
public class ProdutoDAOTest {
    
    @Test
    public void testSalvar() {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto(1, "Produto 1", 10.0);
        dao.salvar(produto);
        
        Produto produtoSalvo = dao.buscar(1);
        assertNotNull(produtoSalvo, "O produto deve ser salvo e não deve ser nulo.");
        assertEquals("Produto 1", produtoSalvo.getNome());
    }
    
    @Test
    public void testDeletar() {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto(1, "Produto 1", 10.0);
        dao.salvar(produto);
        dao.deletar(produto);
        
        Produto produtoDeletado = dao.buscar(1);
        assertNull(produtoDeletado, "O produto deletado não deve ser encontrado.");
    }
    
    @Test
    public void testBuscar() {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto(1, "Produto 1", 10.0);
        dao.salvar(produto);
        
        Produto produtoBuscado = dao.buscar(1);
        assertNotNull(produtoBuscado, "O produto deve ser encontrado.");
        assertEquals("Produto 1", produtoBuscado.getNome());
    }
    
    @Test
    public void testEditar() {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto(1, "Produto 1", 10.0);
        dao.salvar(produto);
        
        Produto produtoEditado = new Produto(1, "Produto Editado", 20.0);
        dao.editar(produtoEditado);
        
        Produto produtoAtualizado = dao.buscar(1);
        assertEquals("Produto Editado", produtoAtualizado.getNome());
        assertEquals(20.0, produtoAtualizado.getPreco());
    }
}