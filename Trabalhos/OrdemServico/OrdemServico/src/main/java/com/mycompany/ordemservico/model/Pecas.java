/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordemservico.model;

import java.math.BigDecimal;

/**
 *
 * @author aluno
 */
public class Pecas {
    
    public String nomePeca;
    public int qtdPeca;
    public BigDecimal valorUnitario;

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public int getQtdPeca() {
        return qtdPeca;
    }

    public void setQtdPeca(int qtdPeca) {
        this.qtdPeca = qtdPeca;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    
}
