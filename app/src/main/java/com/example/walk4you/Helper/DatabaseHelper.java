package com.example.walk4you.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "DbWalkForYou";

    public static final String TABELLA_UTENTE  = "Utente";

    public static final String KEY_MAIL = "mail";
    public static final String KEY_NOME = "nome";
    public static final String KEY_COGNOME = "cognome";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_ALTEZZA = "altezza";
    public static final String KEY_SESSO = "Sesso";
    public static final String KEY_PUNTEGGIO = "Punteggio";
    public static final String KEY_DATA_NASCITA ="data nascita";



    private static final String CREATE_TABELLA_UTENTE = "CREATE TABLE " +  TABELLA_UTENTE + "("
            + KEY_MAIL + "INTEGER PRIMARY KEY,"
            + KEY_NOME + "TEXT"
            + KEY_COGNOME + "TEXT"
            + KEY_PASSWORD + "TEXT"
            + KEY_ALTEZZA +"NUMRO"
            + KEY_SESSO + "TEXT"
            + KEY_PUNTEGGIO + "NUMERO"
            + KEY_DATA_NASCITA + "DATA" + ")";

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABELLA_UTENTE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_UTENTE );

        onCreate(db);
    }


}
