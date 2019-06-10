package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.TABELLA_PREMI;
import static com.example.walk4you.util.Constants.ID_PREMI;
import static com.example.walk4you.util.Constants.NOME_PREMIO;
import static com.example.walk4you.util.Constants.PUNTEGGIO_PREMI;
import static com.example.walk4you.util.Constants.LIVELLO_PREMI;
import static com.example.walk4you.util.Constants.QR_CODE;



public class AdapterPremi {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterPremi.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterPremi(Context context) { this.context = context;}

    public AdapterPremi open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String codice_QR , String nome_premio, String punteggio_premi, String livello_premi) {
        ContentValues values = new ContentValues();
        values.put (QR_CODE, codice_QR);
        values.put (NOME_PREMIO, nome_premio);
        values.put (PUNTEGGIO_PREMI, punteggio_premi);
        values.put (LIVELLO_PREMI, livello_premi);

        return values;
    }
    // create a contact
    public long createContactPremi (String codice_QR , String nome_premio, String punteggio_premi, String livello_premi){
        ContentValues initialValues = createContentVAlues(codice_QR, nome_premio, punteggio_premi, livello_premi);
        return  database.insertOrThrow(TABELLA_PREMI, null, initialValues);
    }
    //upadate contact
    public boolean updateContactPremi (long contactID, String tipologia_ristorante, String descrizione, String posizione_gps_lat, String posizione_gps_long ){
        ContentValues updateValues = createContentVAlues(tipologia_ristorante, descrizione, posizione_gps_lat, posizione_gps_long);
        return database.update (TABELLA_PREMI, updateValues,ID_PREMI + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactPremi (long contactID) {
        return database.delete(TABELLA_PREMI, ID_PREMI + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllPremi() {
        return database.query(TABELLA_PREMI, new String[] {
                ID_PREMI, QR_CODE, NOME_PREMIO, PUNTEGGIO_PREMI, LIVELLO_PREMI}, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchPremiByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_PREMI, new String[] {
                        ID_PREMI, QR_CODE, NOME_PREMIO, PUNTEGGIO_PREMI, LIVELLO_PREMI},
                ID_PREMI + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }
}
