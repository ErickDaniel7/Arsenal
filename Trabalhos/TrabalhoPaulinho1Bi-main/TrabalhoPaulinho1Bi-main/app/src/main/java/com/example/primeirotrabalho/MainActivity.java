package com.example.primeirotrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edNome;
    EditText edEmail;
    EditText edIdade;
    EditText edDisciplina;
    EditText edPriBim;
    EditText edSegBim;
    Button btConfirmar;

    Button btLimpar;


    TextView tvNomeRes;
    TextView tvIdadeRes;
    TextView tvEmailRes;
    TextView tvDisciplinaRes;
    TextView tvNotasRes;
    TextView tvMediaRes;
    TextView tvMsgRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edNome = findViewById(R.id.edNome);
        this.edEmail = findViewById(R.id.edEmail);
        this.edIdade = findViewById(R.id.edIdade);
        this.edDisciplina = findViewById(R.id.edDisciplina);
        this.edPriBim = findViewById(R.id.edPriBim);
        this.edSegBim = findViewById(R.id.edSegBim);
        this.btConfirmar = findViewById(R.id.btConfirmar);
        this.btLimpar = findViewById(R.id.btLimpar);
        this.tvNomeRes = findViewById(R.id.tvNomeRes);
        this.tvEmailRes = findViewById(R.id.tvEmailRes);
        this.tvIdadeRes = findViewById(R.id.tvIdadeRes);
        this.tvDisciplinaRes = findViewById(R.id.tvDisciplinaRes);
        this.tvNotasRes = findViewById(R.id.tvNotasRes);
        this.tvMediaRes = findViewById(R.id.tvMediaRes);
        this.tvMsgRes = findViewById(R.id.tvMsgRes);


        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarInfo();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
            }
        });
    }

    private void validarInfo() {
        String nome = edNome.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String idadeStr = edIdade.getText().toString().trim();
        String disciplina = edDisciplina.getText().toString().trim();
        String priBimStr = edPriBim.getText().toString().trim();
        String segBimStr = edSegBim.getText().toString().trim();
        String msg = "";


        if (nome.isEmpty()) {
            msg = "Nome não pode estar vazio";
        }
        if (email.isEmpty()) {
            msg ="Email não pode estar vazio";
        }
        if (disciplina.isEmpty()) {
            msg = "Disciplina não pode estar vazia";
        }
        if (idadeStr.isEmpty() || !isNumeric(idadeStr, true)) {
            msg = "Idade deve ser um número válido";
        }
        if (priBimStr.isEmpty() || !isNumeric(priBimStr, false)) {
            msg = "1º Bimestre deve ser um número válido";
        }
        if (segBimStr.isEmpty() || !isNumeric(segBimStr, false)) {
            msg = "2º Bimestre deve ser um número válido";
        }
        if (msg.length() > 0) {
            tvMsgRes.setText(msg);
        }else{
            tvNomeRes.setText(edNome.getText().toString());
            tvEmailRes.setText(edEmail.getText().toString());
            tvIdadeRes.setText(edIdade.getText().toString());
            tvDisciplinaRes.setText(edDisciplina.getText().toString());
            tvNotasRes.setText("1º: "+ edPriBim.getText().toString() + " e 2º: "+ edSegBim.getText().toString());
            tvMediaRes.setText(CalcularMedia(edPriBim.getText().toString(), edSegBim.getText().toString()));
        }

    }

    private boolean isNumeric(String str, boolean isIdade) {
        try {
            if (isIdade) {
                double idade = Double.parseDouble(str);
                return idade > 0;
            } else {
                double nota = Double.parseDouble(str);
                if(nota > 0 && nota < 10){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void limparCampos() {
        edNome.setText("");
        edEmail.setText("");
        edIdade.setText("");
        edDisciplina.setText("");
        edPriBim.setText("");
        edSegBim.setText("");
        tvNomeRes.setText("");
        tvEmailRes.setText("");
        tvIdadeRes.setText("");
        tvDisciplinaRes.setText("");
        tvNotasRes.setText("");
        tvMediaRes.setText("");
        tvMsgRes.setText("");

    }

    private String CalcularMedia(String nota1, String nota2){
        Double nota1bi = Double.parseDouble(nota1);
        Double nota2bi = Double.parseDouble(nota2);
        Double media = 0.0;
        media = (nota1bi+nota2bi)/2;
        if(media < 6){
            tvMsgRes.setText("Reprovado");
        }else{
            tvMsgRes.setText("Aprovado");
        }
        return media.toString();
    }
}