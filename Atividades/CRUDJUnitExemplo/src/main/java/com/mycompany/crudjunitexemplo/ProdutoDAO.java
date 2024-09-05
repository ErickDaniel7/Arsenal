/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjunitexemplo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erixk
 */
public class ProdutoDAO {
    
    // Simula o banco de dados com uma lista
    private List<Produto> produtos = new ArrayList<>();
    
    // Salvar
    public void salvar(Produto produto) {
        produtos.add(produto);
    }
    
    // Deletar
    public void deletar(Produto produto) {
        produtos.remove(produto);
    }
    
    // Buscar
    public Produto buscar(int id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // Editar
    public void editar(Produto produtoEditado) {
        for (Produto produto : produtos) {
            if (produto.getId() == produtoEditado.getId()) {
                produto.setNome(produtoEditado.getNome());
                produto.setPreco(produtoEditado.getPreco());
            }
        }
    }
}

