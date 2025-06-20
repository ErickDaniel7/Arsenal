package com.example.exerc3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edTempoGasto, edVelocidadeMedia, edMedia;
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