package com.example.aplicativopontodevenda.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.aplicativopontodevenda.dao.PagamentoDao;
import com.example.aplicativopontodevenda.model.PagamentoModel;

import java.util.ArrayList;

public class PagamentoController {
    private Context context;

    public PagamentoController(Context context) {
        this.context = context;
    }

    public String cadastrarPagamento(int id_pedido, double valor_pago, String metodo_pagamento) {
        try {
            if (valor_pago <= 0) {
                return "O VALOR PAGO DEVE SER MAIOR QUE ZERO!";
            }

            PagamentoModel pagamento = new PagamentoModel();
            pagamento.setId_pedido(id_pedido);
            pagamento.setValor_pago(valor_pago);
            pagamento.setMetodo_pagamento(metodo_pagamento);

            PagamentoDao.getInstancia(context).insert(pagamento);
            showToast("Pagamento cadastrado com sucesso!");

        } catch (Exception ex) {
            return "ERRO AO GRAVAR!!";
        }
        return null;
    }

    public ArrayList <PagamentoModel> listarPagamentos() {
        return PagamentoDao.getInstancia(context).getAll();
    }

    private void showToast(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
