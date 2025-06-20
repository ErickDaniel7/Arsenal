package com.example.exerc2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edLarguraA, edLarguraB, edAlturaA, edAlturaB;
    TextView tvPerimetro, tvArea;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLarguraA = findViewById(R.id.edLarguraA);
        edLarguraB = findViewById(R.id.edLarguraB);
        edAlturaA = findViewById(R.id.edAlturaA);
        edAlturaB = findViewById(R.id.edAlturaB);
        tvPerimetro = findViewById(R.id.tvPerimetro);
        tvArea = findViewById(R.id.tvArea);
        btCalcular = findViewById(R.id.btCalcular);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double larguraA = Double.parseDouble(edLarguraA.getText().toString());
                double larguraB = Double.parseDouble(edLarguraB.getText().toString());
                double alturaA = Double.parseDouble(edAlturaA.getText().toString());
                double alturaB = Double.parseDouble(edAlturaB.getText().toString());


                double perimetro = 2 * (larguraA + larguraB + alturaA + alturaB);
                double area = larguraA * larguraB;

                tvPerimetro.setText(String.format("%.2f", perimetro));
                tvArea.setText(String.format("%.2f", area));
            }
        });
    }
}
