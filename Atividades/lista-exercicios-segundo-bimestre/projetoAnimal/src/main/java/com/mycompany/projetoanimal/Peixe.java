/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoanimal;

/**
 *
 * @author aluno
 */
public class Peixe extends Animal {
    private String caracteristica;

    public Peixe(String nome, String caracteristica, int comprimento, float velocidade) {
        super(nome, "Cinzento", "Mar", comprimento, velocidade, 0);
        this.caracteristica = caracteristica;
    }

    public void alteraCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String caracteristica() {
        return caracteristica;
    }

    public void dados() {
        super.dados();
        System.out.println("Caracteristica: " + caracteristica);
    }
}
