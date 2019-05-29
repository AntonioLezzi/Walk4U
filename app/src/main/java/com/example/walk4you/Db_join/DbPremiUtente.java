package com.example.walk4you.Db_join;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.walk4you.Db_tabelle.DBHelper;

import java.sql.Date;

public class DbPremiUtente extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    public DbPremiUtente(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "premi_utente";
    private static final String COLUMN_ID = "mail";
    private static final String COLUMN_ID_2 = "id_premio";
    private static final String COLUMN_NAME = "nome";
    private static final Date COLUMN_DATA = Date.valueOf("data");

    private static final String CREATE_TABLE_PREMI = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " TEXT, " + COLUMN_ID_2 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, " + COLUMN_DATA + " DATE )";



    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_PREMI);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS premi_utente");
        onCreate(database);
    }


    public DbPremiUtente open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = this.getWritableDatabase();
        return this;
    }
    public void close() {
        if(dbHelper!= null){
            dbHelper.close();
        }
    }

}
