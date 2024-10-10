package com.example.atividade3;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edTempoGasto;
    private EditText edVelocidadeMedia;
    private EditText edMedia;
    private Button btCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTempoGasto = findViewById(R.id.edTempoGasto);
        edVelocidadeMedia = findViewById(R.id.edVelocidadeMedia);
        edMedia = findViewById(R.id.edMedia);
        btCalcular = findViewById(R.id.btCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularLitrosUsados();
            }
        });
    }

    private void calcularLitrosUsados() {

        double tempoGasto = parseInput(edTempoGasto);
        double velocidadeMedia = parseInput(edVelocidadeMedia);
        double mediaConsumo = parseInput(edMedia);

        double distancia = tempoGasto * velocidadeMedia;

        double litrosUsados = distancia / mediaConsumo;

        tvResultado.setText("Litros usados: " + String.format("%.2f", litrosUsados));
    }

    private double parseInput(EditText editText) {
        String input = editText.getText().toString();
        if (input.isEmpty()) {
            return 0.0;
        } else {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
    }
}