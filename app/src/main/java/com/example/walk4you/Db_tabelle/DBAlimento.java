package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAlimento extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "alimenti";
    private static  final int COLUMN_ID = Integer.parseInt("id_alimento");
    private static  final String COLUMN_NOME = "nome";
    private static  final double COLUMN_GRASSI = Double.parseDouble("grassi");
    private static  final double COLUMN_FIBRE = Double.parseDouble("fibre");
    private static  final double COLUMN_VITAMINA_C = Double.parseDouble("vitamina_c");
    private static  final double COLUMN_CALCIO = Double.parseDouble("calcio");
    private static  final double COLUMN_SODIO = Double.parseDouble("sodio");
    private static  final double COLUMN_PROTEINE = Double.parseDouble("proteine");
    private static  final double COLUMN_POTASSIO = Double.parseDouble("potassio");
    private static  final double COLUMN_FERRO = Double.parseDouble("ferro");

    private static final String CREATE_TABLE_ALIMENTO = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOME + "TEXT, " +
            + COLUMN_FERRO + " INTEGER, " + COLUMN_FIBRE + "INTEGER, " + COLUMN_POTASSIO + "INTEGER, " + COLUMN_PROTEINE + "INTEGER, " +  COLUMN_VITAMINA_C + "INTEGER, "
            + COLUMN_GRASSI + "INTEGER, " + COLUMN_SODIO + " INTEGER, " + COLUMN_CALCIO + " INTEGER )";


    public DBAlimento(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_ALIMENTO);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS alimento");
        onCreate(database);
    }


    public DBAlimento open() throws SQLException {
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
