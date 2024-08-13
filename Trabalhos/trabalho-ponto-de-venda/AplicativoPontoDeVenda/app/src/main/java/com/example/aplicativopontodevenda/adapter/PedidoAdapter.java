package com.example.aplicativopontodevenda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopontodevenda.R;
import com.example.aplicativopontodevenda.model.PedidoModel;

import java.util.ArrayList;
import java.util.List;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidosViewHolder> {

    private List<PedidoModel> listaPedido;
    private Context context;

    public PedidoAdapter(ArrayList<PedidoModel> listaPedidos, Context context) {
        this.listaPedido = listaPedidos;
        this.context = context;
    }

    @NonNull
    @Override
    public PedidosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);

        return new PedidosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosViewHolder holder, int position) {
        PedidoModel pedido = listaPedido.get(position);

        holder.tvProduto.setText("Produto " + pedido.getProduto());
        holder.tvQuantidade.setText("Quantidade: " + pedido.getQuantidade());
        holder.tvValorTotal.setText("ValorTotal: " + pedido.getValor_total());

    }

    @Override
    public int getItemCount() {
        return listaPedido.size();
    }

    public class PedidosViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProduto;
        public TextView tvQuantidade;
        public TextView tvValorTotal;

        public PedidosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProduto = itemView.findViewById(R.id.tvProduto);
            tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
            tvValorTotal = itemView.findViewById(R.id.tvValorTotal);
        }
    }


}
