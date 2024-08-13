package com.example.aplicativopontodevenda.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.aplicativopontodevenda.model.CaixaModel;

import java.util.ArrayList;

public class CaixaController {/*

    private Context context;

    public CaixaController(Context context) {
        this.context = context;
    }

    public void adicionarProduto(String codigoProduto, int quantidade, double valorUnitario) {
        try {
            CaixaModel caixa = new CaixaModel();
            caixa.setCodigoProduto(codigoProduto);
            caixa.setQuantidade(quantidade);
            caixa.setValorUnitario(valorUnitario);

            CaixaDao.getInstancia(context).insert(caixa);
            showToast("Produto adicionado com sucesso!");
        } catch (Exception ex) {
            showToast("Erro ao adicionar produto: " + ex.getMessage());
        }
    }

    public ArrayList<CaixaModel> listarProdutos() {
        return CaixaDao.getInstancia(context).getAll();
    }

    // Implemente outros métodos necessários para o controle do caixa.
    // ...

    private void showToast(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
    */
}
