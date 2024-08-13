package com.example.aplicativopontodevenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.aplicativopontodevenda.helper.SQLiteDataHelper;
import com.example.aplicativopontodevenda.model.LoginModel;
import com.example.aplicativopontodevenda.model.PedidoModel;

import java.util.ArrayList;

public class PedidoDao  implements IGenericDao<PedidoModel> {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[] colunas = {"CODIGO", "PRODUTO", "QUANTIDADE", "VALOR_TOTAL"};
    private String tabela = "PEDIDOS";
    private Context context;
    private static PedidoDao instancia;

    public static PedidoDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new PedidoDao(context);
        } else {
            return instancia;
        }
    }

    private PedidoDao(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "PONTO_VENDA", null, 1);
        baseDados = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(PedidoModel obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getProduto());
            valores.put(colunas[2], obj.getQuantidade());
            valores.put(colunas[3], obj.getValor_total());

            return baseDados.insert(tabela, null, valores);

        } catch (SQLException ex) {
            Log.e("PONTO_VENDA", "ERRO: PedidoDao.insert() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(PedidoModel obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getProduto());
            valores.put(colunas[2], obj.getQuantidade());
            valores.put(colunas[3], obj.getValor_total());

            String[] identificador = {String.valueOf(obj.getCodigo())};

            return baseDados.update(tabela, valores, colunas[0] + " = ?", identificador);

        } catch (SQLException ex) {
            Log.e("PONTO_VENDA", "ERRO: PedidoDao.update() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(PedidoModel obj) {
        try {
            String[] identificador = {String.valueOf(obj.getCodigo())};

            return baseDados.delete(tabela, colunas[0] + " = ?", identificador);

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PedidoDao.delete " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<PedidoModel> getAll() {
        ArrayList<PedidoModel> lista = new ArrayList<>();

        try {

            Cursor cursor = baseDados.query(tabela, colunas,
                    null, null, null, null, colunas[0] + " DESC");

            if (cursor.moveToFirst()) {
                do {
                    PedidoModel pedido = new PedidoModel();
                    pedido.setCodigo(cursor.getInt(0));
                    pedido.setProduto(cursor.getString(1));
                    pedido.setQuantidade(cursor.getDouble(2));
                    pedido.setValor_total(cursor.getInt(3));

                    lista.add(pedido);

                } while (cursor.moveToNext());
            }

            cursor.close();

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PedidoDao.getAll " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public PedidoModel getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0] + " = ?", identificador,
                    null, null, null);

            if (cursor.moveToFirst()) {
                PedidoModel pedido = new PedidoModel();
                pedido.setCodigo(cursor.getInt(0));
                pedido.setProduto(cursor.getString(1));
                pedido.setQuantidade(cursor.getDouble(2));
                pedido.setValor_total(cursor.getInt(3));

                return pedido;
            }

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PedidoDao.getById() " + ex.getMessage());
        }
        return null;
    }
}

