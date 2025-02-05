package com.example.examen2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private EditText editTextInput;
    private TextView textViewResult;
    private Spinner spinnerBase;
    private int baseSeleccionada;
    private EditText editTextElement;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextElement = findViewById(R.id.editTextElement);
        textViewResultado = findViewById(R.id.textViewResultado);
        editTextInput = findViewById(R.id.editTextInput);
        textViewResult = findViewById(R.id.textViewResult);
        spinnerBase = findViewById(R.id.spinnerBase);

        Button buttonBuscar = findViewById(R.id.buttonBuscar);

        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextElement.getText().toString();
                if (!input.isEmpty()) {
                    int numero = Integer.parseInt(input);
                    boolean encontrado = Calculadora.Encuentra(listaNumeros, numero);
                    textViewResultado.setText(encontrado ? "Número encontrado ✅" : "Número no encontrado ❌");
                } else {
                    textViewResultado.setText("Por favor, ingrese un número");
                }
            }
        });

        // Configurar el Spinner para seleccionar la base
        spinnerBase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                baseSeleccionada = position; // 0 - Binario, 1 - Octal, 2 - Decimal, 3 - Hexadecimal
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                baseSeleccionada = 2; // Por defecto, Decimal
            }
        });

        // Configurar los botones de operaciones
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonConvertir = findViewById(R.id.buttonConvertir);

        buttonAdd.setOnClickListener(v -> realizarOperacion("+"));
        buttonSubtract.setOnClickListener(v -> realizarOperacion("-"));
        buttonMultiply.setOnClickListener(v -> realizarOperacion("*"));
        buttonDivide.setOnClickListener(v -> realizarOperacion("/"));
        buttonConvertir.setOnClickListener(v -> convertirEntreBases());
    }

    // Método para realizar las operaciones matemáticas básicas
    private void realizarOperacion(String operador) {
        String input = editTextInput.getText().toString().trim();
        if (input.isEmpty()) {
            textViewResult.setText("Ingrese un número");
            return;
        }

        // Convertir el número ingresado a base 10
        int num1 = Calculadora.convertirNumero(input, baseSeleccionada);
        int num2 = 10; // Para simplificación, usaremos 10 como número base decimal

        if (num1 == -1) {
            textViewResult.setText("Error: Número inválido");
            return;
        }

        int resultado = 0;
        try {
            resultado = Calculadora.realizarOperacion(num1, num2, operador);
            textViewResult.setText("Resultado: " + Integer.toString(resultado, baseSeleccionada).toUpperCase());
        } catch (Exception e) {
            textViewResult.setText("Error: " + e.getMessage());
        }
    }

    // Método para convertir entre bases
    private void convertirEntreBases() {
        String input = editTextInput.getText().toString().trim();
        if (input.isEmpty()) {
            textViewResult.setText("Ingrese un número");
            return;
        }

        int baseOrigen = spinnerBase.getSelectedItemPosition();
        int baseDestino = baseSeleccionada;

        // Convertir a base decimal
        int numeroDecimal = Calculadora.convertirNumero(input, baseOrigen);
        if (numeroDecimal == -1) {
            textViewResult.setText("Error: Número inválido");
            return;
        }

        // Mostrar la conversión a la base destino
        String resultadoConvertido = Calculadora.convertirADestino(numeroDecimal, baseDestino);
        textViewResult.setText("Resultado: " + resultadoConvertido.toUpperCase());
    }
}