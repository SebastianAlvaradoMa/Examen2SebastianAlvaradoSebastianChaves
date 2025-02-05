package com.example.examen2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testRealizarOperacion_Resta() {
        assertEquals(1, Calculadora.realizarOperacion(5, 4, "-"));
    }

    @Test
    public void testConvertirADestino_Octal() {
        assertEquals("12", Calculadora.convertirADestino(10, 1));
    }

    @Test
    public void testConvertirADestino_Decimal() {
        assertEquals("10", Calculadora.convertirADestino(10, 2));
    }

    @Test
    public void testEncuentra_ElementoPresente() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        assertTrue(Calculadora.Encuentra(lista, 3)); // Debería ser true
    }
}

