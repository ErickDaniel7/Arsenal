package com.example.aplicativopontodevenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.aplicativopontodevenda.helper.SQLiteDataHelper;
import com.example.aplicativopontodevenda.model.PagamentoModel;

import java.util.ArrayList;

public class PagamentoDao implements IGenericDao<PagamentoModel>{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[] colunas = {"ID", "ID_PEDIDO", "VALOR_PAGO", "METODO_PAGAMENTO"};
    private String tabela = "PAGAMENTO";
    private Context context;
    private static PagamentoDao instancia;

    public static PagamentoDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new PagamentoDao(context);
        } else {
            return instancia;
        }
    }

    private PagamentoDao(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "PONTO_VENDA", null, 1);
        baseDados = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(PagamentoModel obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getId_pedido());
            valores.put(colunas[2], obj.getValor_pago());
            valores.put(colunas[3], obj.getMetodo_pagamento());

            return baseDados.insert(tabela, null, valores);

        } catch (SQLException ex) {
            Log.e("PONTO_VENDA", "ERRO: PagamentoDao.insert() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(PagamentoModel obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getId_pedido());
            valores.put(colunas[2], obj.getValor_pago());
            valores.put(colunas[3], obj.getMetodo_pagamento());

            String[] identificador = {String.valueOf(obj.getId())};

            return baseDados.update(tabela, valores, colunas[0] + " = ?", identificador);

        } catch (SQLException ex) {
            Log.e("PONTO_VENDA", "ERRO: PagamentoDao.update() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(PagamentoModel obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};

            return baseDados.delete(tabela, colunas[0] + " = ?", identificador);

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PagamentoDao.delete " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<PagamentoModel> getAll() {
        ArrayList<PagamentoModel> lista = new ArrayList<>();

        try {

            Cursor cursor = baseDados.query(tabela, colunas,
                    null, null, null, null, colunas[0] + " DESC");

            if (cursor.moveToFirst()) {
                do {
                    PagamentoModel pagamento = new PagamentoModel();
                    pagamento.setId(cursor.getInt(0));
                    pagamento.setId_pedido(cursor.getInt(1));
                    pagamento.setValor_pago(cursor.getDouble(2));
                    pagamento.setMetodo_pagamento(cursor.getString(3));

                    lista.add(pagamento);

                } while (cursor.moveToNext());
            }

            cursor.close();

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PagamentoDao.getAll " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public PagamentoModel getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0] + " = ?", identificador,
                    null, null, null);

            if (cursor.moveToFirst()) {
                PagamentoModel pagamento = new PagamentoModel();
                pagamento.setId(cursor.getInt(0));
                pagamento.setId_pedido(cursor.getInt(1));
                pagamento.setValor_pago(cursor.getDouble(2));
                pagamento.setMetodo_pagamento(cursor.getString(3));

                return pagamento;
            }

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: PagamentoDao.getById() " + ex.getMessage());
        }
        return null;
    }
}
