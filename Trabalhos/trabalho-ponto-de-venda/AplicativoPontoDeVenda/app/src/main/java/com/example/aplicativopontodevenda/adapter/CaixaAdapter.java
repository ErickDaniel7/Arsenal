package com.example.aplicativopontodevenda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aplicativopontodevenda.model.CaixaModel;
import com.example.aplicativopontodevenda.R;

import java.util.ArrayList;

public class CaixaAdapter  {/*

    private Context context;
    private ArrayList<CaixaModel> listaCaixa;

    public CaixaAdapter(Context context, ArrayList<CaixaModel> listaCaixa) {
        this.context = context;
        this.listaCaixa = listaCaixa;
    }

    @Override
    public int getCount() {
        return listaCaixa.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCaixa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_caixa, null);
        }

        // Obtenha o item atual
        CaixaModel caixa = listaCaixa.get(position);

        // Atualize os elementos da interface do usuário com os dados do item atual
        TextView codigoProdutoTextView = view.findViewById(R.id.txtCodigoProduto);
        TextView quantidadeTextView = view.findViewById(R.id.txtQuantidade);
        TextView valorUnitarioTextView = view.findViewById(R.id.txtValorUnitario);

        codigoProdutoTextView.setText(caixa.getCodigoProduto());
        quantidadeTextView.setText("Quantidade: " + String.valueOf(caixa.getQuantidade()));
        valorUnitarioTextView.setText("Valor Unitário: R$ " + String.format("%.2f", caixa.getValorUnitario()));

        return view;
    }
    */
}
