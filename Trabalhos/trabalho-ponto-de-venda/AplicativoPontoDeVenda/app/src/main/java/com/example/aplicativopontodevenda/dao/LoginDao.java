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

import java.util.ArrayList;

public class LoginDao implements IGenericDao<LoginModel> {

    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase baseDados;

    private String[]colunas = {"ID, NOME_LOGIN", "EMAIL_LOGIN", "SENHA_LOGIN"};

    private String tabela = "LOGIN";

    private Context context;

    private static LoginDao instancia;

    public static LoginDao getInstancia(Context context){
        if (instancia == null){
            return instancia = new LoginDao(context);
        }else{
            return instancia;
        }
    }


    private LoginDao (Context context){
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context,"PONTO_VENDA", null, 1 );

        baseDados = openHelper.getWritableDatabase();
    }


    @Override
    public long insert(LoginModel obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome_login());
            valores.put(colunas[2], obj.getEmail_login());
            valores.put(colunas[3], obj.getSenha_login());

            return baseDados.insert(tabela, null, valores);

            //return baseDados.execSQL("INSERT INTO LOGIN (NOME_LOGIN, EMAIL_LOGIN, SENHA_LOGIN) VALUES" +
           //             obj.getNome_login()+","+obj.getEmail_login()+","+obj.getSenha_login()+")");

        }catch (SQLException ex){
            Log.e("PONTO_VENDA", "ERRO: LoginDao.insert() "+ ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(LoginModel obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome_login());
            valores.put(colunas[2], obj.getEmail_login());
            valores.put(colunas[3], obj.getSenha_login());

            String[]identificador = {String.valueOf(obj.getId())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);

        } catch (SQLException ex) {
            Log.e("PONTO_VENDA", "ERRO: LoginDao.update() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(LoginModel obj) {
        try{
            String[]identificador = {String.valueOf(obj.getId())};

            return baseDados.delete(tabela, colunas [0] + "?", identificador);

        }catch (SQLException ex){
            Log.e("PONTO-VENDA", "ERRO: LoginDao.delete " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<LoginModel> getAll() {
        ArrayList<LoginModel> lista = new ArrayList<>();

        try {

            Cursor cursor = baseDados.query(tabela, colunas,
                    null, null, null, null, colunas[0] + " DESC");

            if (cursor.moveToFirst()) {
                do {
                    LoginModel login = new LoginModel();
                    login.setId(cursor.getInt(0));
                    login.setNome_login(cursor.getString(1));
                    login.setEmail_login(cursor.getString(2));
                    login.setSenha_login(cursor.getString(3));

                    lista.add(login);

                } while (cursor.moveToNext());
            }

            cursor.close();

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: LoginDao.getAll " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public LoginModel getById(int id) {
            try{
                String[]identificador = {String.valueOf(id)};
                Cursor cursor = baseDados.query(tabela, colunas,
                        colunas[0]+"= ?", identificador,
                        null, null, null);

                if(cursor.moveToFirst()){
                    LoginModel login = new LoginModel();
                    login.setId(cursor.getInt(0));
                    login.setNome_login(cursor.getString(1));
                    login.setEmail_login(cursor.getString(2));
                    login.setSenha_login(cursor.getString(3));

                    return login;
                }

            }catch (SQLException ex){
                Log.e("PONTO-VENDA", "ERRO: LoginDao.getById() "+ex.getMessage());
            }
            return null;
        }

    public LoginModel getByEmail(String email) {
        try {
            String[] identificador = {email};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[2] + " = ?", identificador,
                    null, null, null);

            if (cursor.moveToFirst()) {
                LoginModel login = new LoginModel();
                login.setId(cursor.getInt(0));
                login.setNome_login(cursor.getString(1));
                login.setEmail_login(cursor.getString(2));
                login.setSenha_login(cursor.getString(3));

                cursor.close();

                return login;
            }

            cursor.close();

        } catch (SQLException ex) {
            Log.e("PONTO-VENDA", "ERRO: LoginDao.getByEmail() " + ex.getMessage());
        }
        return null;
    }
}
