package com.example.walk4you.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.walk4you.util.MyApp;

import static com.example.walk4you.util.Constants.*;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "DbWalkForYou";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper databaseHelper;

    public DatabaseHelper () {
        super(MyApp.context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {

        if (databaseHelper == null) {
            synchronized (DatabaseHelper.class){ //thread safe singleton
                if (databaseHelper == null)
                    databaseHelper = new DatabaseHelper();
            }
        }

        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

         String CREATE_TABELLA_UTENTE = "CREATE TABLE " + TABELLA_UTENTE + "("
                + MAIL + "INTEGER PRIMARY KEY,"
                + NOME + "TEXT NOT NULL,"
                + COGNOME + "TEXT NOT NULL,"
                + PASSWORD + "TEXT NOT NULL,"
                + ALTEZZA + "NUMRO"
                + SESSO + "TEXT"
                + DATA_NASCITA + "DATA" + ")";

        sqLiteDatabase.execSQL(CREATE_TABELLA_UTENTE);
    }


    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_UTENTE );

        onCreate(db);
    }

    @Override
    public void onOpen (SQLiteDatabase db) {
        super.onOpen(db);

        db.execSQL("PRAGMA foreign_keys=ON");
    }


}
