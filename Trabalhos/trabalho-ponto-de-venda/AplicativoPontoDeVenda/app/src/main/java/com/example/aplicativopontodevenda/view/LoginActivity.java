package com.example.aplicativopontodevenda.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopontodevenda.R;
import com.example.aplicativopontodevenda.controller.LoginController;
import com.example.aplicativopontodevenda.model.LoginModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    private EditText edSenha;
    private LoginController controller;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        controller = new LoginController(this);


    }


        private void salvarLogin(){

        String retorno = controller.salvarLogin((edNome.getText().toString()), edEmail.getText().toString(), edSenha.getText().toString());

        if (retorno != null){
            if (retorno.contains("NOME")){
                edNome.setError(retorno);
                edNome.requestFocus();
            }else if (retorno.contains("EMAIL")){
                edEmail.setError(retorno);
                edEmail.requestFocus();
            } else if (retorno.contains("SENHA")) {
                edSenha.setError(retorno);
                edSenha.requestFocus();
            }else{
                Toast.makeText(this, edNome+" FOI CADASTRADO COM SUCESSO!!", Toast.LENGTH_LONG).show();


            }
        }

        }

}