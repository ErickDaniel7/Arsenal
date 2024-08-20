/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetos;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Calculadora { 
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int num1, num2;
        double resultado;

        System.out.print("Digite o primeiro número: ");
        num1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        num2 = entrada.nextInt();

        resultado = num1 + num2;
        System.out.println("A soma é: " + resultado);

        resultado = num1 - num2;
        System.out.println("A subtração é: " + resultado);

        resultado = num1 * num2;
        System.out.println("A multiplicação é: " + resultado);

        if (num2 != 0) {
            resultado = (double) num1 / num2;
            System.out.println("A divisão é: " + resultado);
        } else {
            System.out.println("Não é possível dividir por zero.");
        }
    }
}
