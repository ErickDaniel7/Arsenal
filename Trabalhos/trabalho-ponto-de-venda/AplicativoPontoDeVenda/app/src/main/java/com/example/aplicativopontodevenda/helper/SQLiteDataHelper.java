package com.example.aplicativopontodevenda.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PEDIDOS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME_PEDIDO VARCHAR(50), VALOR_TOTAL REAL, QUANTIDADE INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE PAGAMENTO (ID INTEGER PRIMARY KEY AUTOINCREMENT, ID_PEDIDO INTEGER, VALOR_PAGO REAL, METODO_PAGAMENTO VARCHAR(50))");
        sqLiteDatabase.execSQL("CREATE TABLE CAIXA (ID INTEGER PRIMARY KEY AUTOINCREMENT,)");
        sqLiteDatabase.execSQL("CREATE TABLE LOGIN (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME_LOGIN VARCHAR(50), EMAIL_LOGIN VARCHAR (50), SENHA_LOGIN VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
