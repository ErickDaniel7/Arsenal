package com.example.aplicativopontodevenda.model;

public class PedidoModel {

   private int codigo;
    private String produto;
    private double quantidade;
    private int valor_total;

    public PedidoModel() {
    }

    public PedidoModel(int codigo, String produto, int quantidade, double valor_total) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_total = (int) valor_total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }
}



