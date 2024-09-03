/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.junitexample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aluno
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

   @Test
    public void testSomar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(2, 3);
        assertEquals(5, resultado, "A soma de 2 + 3 deve ser 5");
        System.out.println("Resultado Soma: " + resultado);
}
   @Test
    public void testSubtrair() {
        Calculadora calc = new Calculadora();
        int resultado = calc.subtrair(4, 3);
        assertEquals(1, resultado, "A subtração de 4 + 3 deve ser 1");
        System.out.println("Resultado Subtracao: " + resultado);
}
   @Test
    public void testMultiplicar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.multiplicar(4, 3);
        assertEquals(12, resultado, "A multiplicação de 4 + 3 deve ser 12");
        System.out.println("Resultado Multiplicacao: " + resultado);
}
   @Test
    public void testDividir() {
        Calculadora calc = new Calculadora();
        int resultado = calc.dividir(10, 5);
        assertEquals(2, resultado, "A subtração de 10 / 5 deve ser 2");
        System.out.println("Resultado Divisao: " + resultado);
}
}
