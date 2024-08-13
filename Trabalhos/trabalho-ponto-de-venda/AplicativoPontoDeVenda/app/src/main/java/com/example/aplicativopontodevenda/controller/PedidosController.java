package com.example.aplicativopontodevenda.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.aplicativopontodevenda.dao.PedidoDao;
import com.example.aplicativopontodevenda.model.PedidoModel;

import java.util.ArrayList;

public class PedidosController {

    private Context context;

    public PedidosController(Context context) {
        this.context = context;
    }

    public String cadastrarPedido(String produto, double quantidade, int valorTotal) {
        try {
            if (produto.equals("") || produto.isEmpty()) {
                return "INFORME O NOME DO PRODUTO PARA CADASTRO!!";
            }
            PedidoModel pedido = PedidoDao.getInstancia(context).getById(Integer.parseInt(produto));

            if (pedido != null) {
                return "ESSE PRODUTO (" + produto + ") JÁ ESTÁ CADASTRADO!";
            } else {
                pedido = new PedidoModel();
                pedido.setProduto(produto);
                pedido.setQuantidade(quantidade);
                pedido.setValor_total(valorTotal);

                PedidoDao.getInstancia(context).insert(pedido);
                showToast("Pedido cadastrado com sucesso!");
            }

        } catch (Exception ex) {
            return "ERRO AO GRAVAR!!";
        }
        return null;
    }

    public ArrayList<PedidoModel> listarPedidos() {
        return PedidoDao.getInstancia(context).getAll();
    }

    private void showToast(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
