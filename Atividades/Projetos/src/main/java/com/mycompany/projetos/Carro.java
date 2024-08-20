/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetos;

/**
 *
 * @author aluno
 */
public class Carro {
    
    private String modelo;
    private int ano;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void ligar() {
        System.out.println("O seu " + modelo + " está ligado.");
    }

    public static void main(String[] args) {
        Carro carro = new Carro("Opala", 1992);
        carro.ligar();
    }
}
