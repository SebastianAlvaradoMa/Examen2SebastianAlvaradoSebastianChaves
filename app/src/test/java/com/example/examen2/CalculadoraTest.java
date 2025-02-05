package com.example.examen2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    @Test
    public void testConvertirNumero_Binario() {
        assertEquals(10, Calculadora.convertirNumero("1010", 0));
        assertEquals(-1, Calculadora.convertirNumero("102", 0));
    }

    @Test
    public void testConvertirNumero_Hexadecimal() {
        assertEquals(255, Calculadora.convertirNumero("FF", 3));
        assertEquals(-1, Calculadora.convertirNumero("G1", 3));
    }

    @Test
    public void testRealizarOperacion_Suma() {
        assertEquals(15, Calculadora.realizarOperacion(10, 5, "+"));
        assertEquals(-5, Calculadora.realizarOperacion(-10, 5, "+"));
    }
}

