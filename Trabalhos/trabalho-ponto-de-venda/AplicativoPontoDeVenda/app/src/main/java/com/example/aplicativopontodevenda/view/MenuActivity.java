package com.example.aplicativopontodevenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativopontodevenda.R;

public class MenuActivity extends AppCompatActivity {
    private Button buttonIrCaixa;
    private Button buttonCadastrarPedido;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonIrCaixa = findViewById(R.id.buttonIrCaixa);
        buttonCadastrarPedido = findViewById(R.id.buttonCadastrarPedido);


        buttonIrCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("String Text", "teste");
                Intent intent = new Intent(MenuActivity.this,  CaixaActvity.class);

            }
        });


        buttonCadastrarPedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("String Text", "teste");

                 abrirCadastroPedido();
                }

            });
    }

    private void abrirCaixa() {
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroPedido() {
        Intent intent = new Intent(MenuActivity.this, PedidoActivity.class);
        startActivity(intent);

    }



}
