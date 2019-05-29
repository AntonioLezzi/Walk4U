package com.example.walk4you.Db_join;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.walk4you.Db_tabelle.DBHelper;

import java.sql.Date;

public class DbRistoranteUtente extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    public DbRistoranteUtente(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "ristorante_utente";
    private static final String COLUMN_ID = "mail";
    private static final String COLUMN_ID_2 = "id_ristorante";
    private static final Date COLUMN_DATA = Date.valueOf("data");

    private static final String CREATE_TABLE_RISTORANTE_UTENTE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " TEXT, "
            + COLUMN_ID_2 + "INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATA + " DATE )";


    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_RISTORANTE_UTENTE);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS ristorante_utente");
        onCreate(database);
    }


    public DbRistoranteUtente open() throws SQLException {
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
