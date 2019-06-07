package com.example.walk4you.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.walk4you.util.MyApp;

import static com.example.walk4you.util.Constants.*;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "DbWalkForYou";
    private static final int DATABASE_VERSION = 1;

    String CREATE_TABELLA_UTENTE = "CREATE TABLE " + TABELLA_UTENTE + " ("
            + MAIL + " TEXT PRIMARY KEY,"
            + ID_UTENTE + " INTEGER,"
            + NOME + " TEXT NOT NULL,"
            + COGNOME + " TEXT NOT NULL,"
            + PASSWORD + " TEXT NOT NULL,"
            + ALTEZZA + " INTEGER, "
            + SESSO + " TEXT, "
            + DATA_NASCITA + "DATA" + ")";


    String CREATE_TABELLA_NUTRIENTI = "CREATE TABLE " + TABELLA_NUTRIENTI + "("
            + ID_NUTRIENTI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + GRASSI_SATURI + " FLOAT,"
            + FIBRE + " FLOAT,"
            + PROTEINE + " FLOAT,"
            + POTASSIO + " FLOAT,"
            + FERRO + " FLOAT,"
            + VITAMINA_A + " FLOAT,"
            + VITAMINA_C + " FLOAT, "
            + SODIO + " FLOAT" + ")";

    String CREATE_TABELLA_ALIMENTI = "CREATE TABLE " + TABELLA_ALIMENTI + "("
            + ID_ALIMENTI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + INGREDIENTI + " INTEGER, "
            + CODICE_A_BARRE + " INTEGER"
            + ")";

    String CREATE_TABELLA_RISTORANTI = "CREATE TABLE " + TABELLA_RISTORANTI + "("
            + ID_RISTORANTE + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NOME_RISTORANTE + " TEXT"
            + TIPOLOGIA_RISTORANTE + " TEXT"
            + DESCRIZIONE + " TEXT,"
            + POSIZIONE_GPS_LAT + "INTEGER NOT NULL "
            + POSIZIONE_GPS_LONG + "INTEGER NOT NULL"
            + ")";

    String CREATE_TABELLA_PREMI = "CREATE TABLE " + TABELLA_PREMI + "("
            + ID_PREMI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + QR_CODE + " TEXT,"
            + NOME_PREMIO + " TEXT NOT NULL,"
            + PUNTEGGIO_PREMI + " INTEGER NOT NULL,"
            + LIVELLO_PREMI + " INTEGER NOT NULL"
            + ")";


    public DatabaseHelper () {
        super(MyApp.context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Costruttore
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        sqLiteDatabase.execSQL(CREATE_TABELLA_UTENTE);
        sqLiteDatabase.execSQL(CREATE_TABELLA_NUTRIENTI);
        sqLiteDatabase.execSQL(CREATE_TABELLA_ALIMENTI);
        sqLiteDatabase.execSQL(CREATE_TABELLA_RISTORANTI);
        sqLiteDatabase.execSQL(CREATE_TABELLA_PREMI);
    }


    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_UTENTE );
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_NUTRIENTI );
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_ALIMENTI );
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_RISTORANTI );
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_PREMI );


        onCreate(db);
    }

    @Override
    public void onOpen (SQLiteDatabase db) {
        super.onOpen(db);

        db.execSQL("PRAGMA foreign_keys=ON");
    }


}
