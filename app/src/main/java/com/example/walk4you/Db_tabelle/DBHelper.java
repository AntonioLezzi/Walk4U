package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "utente";
    private static final String COLUMN_ID = "mail";
    private static final String COLUMN_NAME = "nome";
    private static final String COLUMN_COGNOME = "cognome";
    private static final float COLUMN_ALTEZZA = Float.parseFloat("altezza");
    private static final String COLUMN_PASSWORD = "password";
    private static final Boolean COLUMN_SESSO_FEMMINILE = Boolean.valueOf("sesso_femminile");
    private static final int COLUMN_PUNTEGGIO = Integer.parseInt("punteggio");
    private static final int COLUMN_LIVELLO = Integer.parseInt("livello");

    private static final String CREATE_TABLE_UTENTE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " TEXT, "
            + COLUMN_NAME + " TEXT, " + COLUMN_COGNOME + "TEXT, " + COLUMN_LIVELLO + "INTEGER, " + COLUMN_ALTEZZA + "INTEGER, "
            + COLUMN_PASSWORD + "TEXT, " + COLUMN_SESSO_FEMMINILE + "TEXT, " + COLUMN_PUNTEGGIO + "INTEGER )";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_UTENTE);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS utente");
        onCreate(database);
    }


    public DBHelper open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = this.getWritableDatabase();
        return this;
    }

    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
    /*public long inserisciPreferiti (String name, String url) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("url", url);

        inserisciPreferiti("Radio1", "http://icestreaming.rai.it/1.mp3");
        inserisciPreferiti("Radio2", "http://icestreaming.rai.it/2.mp3");
        inserisciPreferiti("Radio3", "http://icestreaming.rai.it/3.mp3");
        inserisciPreferiti("Radio24","http://shoutcast.radio24.it:8000/listen.pls");

        return database.insert("preferiti", null, contentValues);

        }

    public Cursor getPreferiti() {
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor mCursor = database.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return mCursor;
    }
}


*/