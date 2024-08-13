package com.example.aplicativopontodevenda.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicativopontodevenda.R;
import com.example.aplicativopontodevenda.controller.LoginController;

public class MainActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    private EditText edSenha;
    private Button btLogin;
    private LoginController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        Button btLogin = findViewById(R.id.btLogin);

        controller = new LoginController(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarLogin();
            }
        });
    }

    private void salvarLogin() {
        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();
        String senha = edSenha.getText().toString();

        String retorno = controller.salvarLogin(nome, email, senha);

        if (retorno != null) {
            if (retorno.contains("NOME")) {
                edNome.setError(retorno);
                edNome.requestFocus();
            } else if (retorno.contains("EMAIL")) {
                edEmail.setError(retorno);
                edEmail.requestFocus();
            } else if (retorno.contains("SENHA")) {
                edSenha.setError(retorno);
                edSenha.requestFocus();
            } else {
                Toast.makeText(MainActivity.this, nome + " FOI CADASTRADO COM SUCESSO!!", Toast.LENGTH_LONG).show();
                realizarLogin();
            }
        }

            }




    private void realizarLogin() {
        String nome = edNome.getText().toString();

        String mensagem = nome+ " VOCÊ FOI CADASTRADO COM SUCESSO";
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,  MenuActivity.class);
        startActivity(intent);
    }
}