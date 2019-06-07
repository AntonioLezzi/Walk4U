package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;


import static com.example.walk4you.util.Constants.ID_UTENTE;
import static com.example.walk4you.util.Constants.MAIL;
import static com.example.walk4you.util.Constants.NOME;
import static com.example.walk4you.util.Constants.COGNOME;
import static com.example.walk4you.util.Constants.ALTEZZA;
import static com.example.walk4you.util.Constants.PASSWORD;
import static com.example.walk4you.util.Constants.SESSO;
import static com.example.walk4you.util.Constants.DATA_NASCITA;
import static com.example.walk4you.util.Constants.TABELLA_UTENTE;


public class AdapterUtente {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterUtente.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterUtente(Context context) { this.context = context;}

    public AdapterUtente open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String mail ,String nome , String cognome, String password, String altezza, String sesso, String data_nascita) {
        ContentValues values = new ContentValues();
        values.put (MAIL, mail);
        values.put (NOME, nome);
        values.put (COGNOME, cognome);
        values.put(PASSWORD, password );
        values.put (ALTEZZA, altezza);
        values.put (SESSO, sesso);
        values.put (DATA_NASCITA, data_nascita);


        return values;
    }
    // create a contact
    public long createContactUtente (String mail ,String nome , String cognome, String password, String altezza, String sesso, String data_nascita){
        ContentValues initialValues = createContentVAlues(mail, nome, cognome, password, altezza, sesso, data_nascita);
        return  database.insertOrThrow(TABELLA_UTENTE, null, initialValues);
    }
    //upadate contact
    public boolean updateContactUtente (long contactID, String mail ,String nome , String cognome, String password, String altezza, String sesso, String data_nascita){
        ContentValues updateValues = createContentVAlues(mail, nome, cognome, password, altezza, sesso, data_nascita);
        return database.update (TABELLA_UTENTE, updateValues,ID_UTENTE + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactUtente (long contactID) {
        return database.delete(TABELLA_UTENTE, ID_UTENTE + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllUtente() {
        return database.query(TABELLA_UTENTE, new String[] {
                ID_UTENTE, MAIL, NOME, COGNOME, PASSWORD, ALTEZZA, SESSO, DATA_NASCITA}, null, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchUtenteByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_UTENTE, new String[] {
                        ID_UTENTE, MAIL, NOME, COGNOME, PASSWORD, ALTEZZA, SESSO, DATA_NASCITA,},
                ID_UTENTE + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }

}

