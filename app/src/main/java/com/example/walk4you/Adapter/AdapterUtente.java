package com.example.walk4you.Adapter;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.MAIL;
import static com.example.walk4you.util.Constants.NOME;
import static com.example.walk4you.util.Constants.COGNOME;
import static com.example.walk4you.util.Constants.ALTEZZA;
import static com.example.walk4you.util.Constants.SESSO;
import static com.example.walk4you.util.Constants.DATA_NASCITA;
import static com.example.walk4you.util.Constants.ID_UTENTE;

public class AdapterUtente {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterUtente.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterUtente(Context context) {
        this.context = context;
    }

    public AdapterUtente open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }


}
