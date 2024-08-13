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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopontodevenda.R;
import com.example.aplicativopontodevenda.adapter.PedidoAdapter;
import com.example.aplicativopontodevenda.controller.PedidosController;
import com.example.aplicativopontodevenda.model.PedidoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PedidoActivity extends AppCompatActivity {

    private EditText edProduto, edQuantidade, edValorTotal;
    private FloatingActionButton btCadastroPedido;
    private RecyclerView rvPedido;
    private AlertDialog pedidoDialog;
    private PedidosController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_pedido);

        btCadastroPedido = findViewById(R.id.btCadastroPedido);
        rvPedido = findViewById(R.id.rvPedido);

        controller = new PedidosController(this);
        btCadastroPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroPedido();
            }
        });
    }

            private void abrirCadastroPedido(){
                View viewAlert = getLayoutInflater()
                        .inflate(R.layout.dialog_cadastro_pedido, null);

                edProduto = viewAlert.findViewById(R.id.edProduto);
                edQuantidade = viewAlert.findViewById(R.id.edQuantidade);
                edValorTotal = viewAlert.findViewById(R.id.edValorTotal);


                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("CADASTRO DE PEDIDO");
                builder.setView(viewAlert);
                builder.setCancelable(false);


                builder.setNegativeButton("Cancelar", null);
                builder.setPositiveButton("Salvar", null);

                pedidoDialog = builder.create();

                //Setando ação no botão salvar
                pedidoDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button btSalvar =
                                pedidoDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        btSalvar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void  onClick(View view) {
                                salvarPedido();
                            }
                        });

                    }
                });
                pedidoDialog.show();
            }

    private void salvarPedido() {
        String retorno = controller.cadastrarPedido(edProduto.getText().toString(),Double.parseDouble(edValorTotal.getText().toString()), Integer.parseInt(
                edQuantidade.getText().toString()));

        if(retorno != null){
            if(retorno.contains("PRODUTO")){
                edProduto.setError(retorno);
                edProduto.requestFocus();
            }else if(retorno.contains("QUANTIDADE")){
                edQuantidade.setError(retorno);
                edQuantidade.requestFocus();
            }
             else if(retorno.contains("VALOR TOTAL")){
            edValorTotal.setError(retorno);
            edValorTotal.requestFocus();
        }else{
                Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();
            }


        }else{
            Toast.makeText(this,
                    "Pedido cadastrado com sucesso!",
                    Toast.LENGTH_LONG).show();
            pedidoDialog.dismiss();
            atualizarListaPagamento();

        }

    }
    public void atualizarListaPagamento() {
        ArrayList<PedidoModel> listaPagamentos = controller.listarPedidos();
        PedidoAdapter adapter = new PedidoAdapter(listaPagamentos, this);
        rvPedido.setLayoutManager(new LinearLayoutManager(this));
        rvPedido.setAdapter(adapter);
    }

}
