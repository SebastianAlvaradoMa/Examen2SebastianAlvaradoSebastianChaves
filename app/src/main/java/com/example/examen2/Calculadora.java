package com.example.examen2;
public class Calculadora {

    // Método para convertir el número a la base seleccionada (0: Binario, 1: Octal, 2: Decimal, 3: Hexadecimal)
    public static int convertirNumero(String input, int base) {
        int numero = 0;
        try {
            switch (base) {
                case 0: // Binario
                    numero = Integer.parseInt(input, 2);
                    break;
                case 1: // Octal
                    numero = Integer.parseInt(input, 8);
                    break;
                case 2: // Decimal
                    numero = Integer.parseInt(input, 10);
                    break;
                case 3: // Hexadecimal
                    numero = Integer.parseInt(input, 16);
                    break;
                default:
                    throw new NumberFormatException("Base no soportada");
            }
        } catch (NumberFormatException e) {
            return -1; // Retornar -1 en caso de error en la conversión
        }
        return numero;
    }

    // Método para realizar operaciones matemáticas (suma, resta, multiplicación, división)
    public static int realizarOperacion(int num1, int num2, String operador) {
        int resultado = 0;
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    throw new ArithmeticException("División por 0");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador no soportado");
        }
        return resultado;
    }

    // Método para convertir un número decimal a cualquier base (0: Binario, 1: Octal, 2: Decimal, 3: Hexadecimal)
    public static String convertirADestino(int numeroDecimal, int baseDestino) {
        switch (baseDestino) {
            case 0: // Binario
                return Integer.toBinaryString(numeroDecimal);
            case 1: // Octal
                return Integer.toOctalString(numeroDecimal);
            case 2: // Decimal
                return Integer.toString(numeroDecimal);
            case 3: // Hexadecimal
                return Integer.toHexString(numeroDecimal);
            default:
                throw new IllegalArgumentException("Base de destino no soportada");
        }
    }
}