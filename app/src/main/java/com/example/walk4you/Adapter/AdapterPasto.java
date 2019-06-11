package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.ALIMENTO;
import static com.example.walk4you.util.Constants.CENA;
import static com.example.walk4you.util.Constants.COLAZIONE;
import static com.example.walk4you.util.Constants.DATA_FINE;
import static com.example.walk4you.util.Constants.DATA_INIZIO;
import static com.example.walk4you.util.Constants.ID_PASTO;
import static com.example.walk4you.util.Constants.PRANZO;
import static com.example.walk4you.util.Constants.SPUNTINO;
import static com.example.walk4you.util.Constants.TABELLA_PASTI;

public class AdapterPasto {

    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterPasto.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterPasto(Context context) { this.context = context;}

    public AdapterPasto open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String id_pasti , String cena , String colazione, String pranzo, String spuntino, String data_inizio, String data_fine, String alimento) {
        ContentValues values = new ContentValues();
        values.put (ID_PASTO, id_pasti);
        values.put (CENA, cena);
        values.put (COLAZIONE, colazione);
        values.put (PRANZO, pranzo);
        values.put (SPUNTINO, spuntino);
        values.put (DATA_INIZIO, data_inizio);
        values.put (DATA_FINE, data_fine);
        values.put (ALIMENTO, alimento);

        return values;
    }
    // create a contact
    public long createContactNutrienti (String id_pasti , String cena , String colazione, String pranzo, String spuntino, String data_inzio, String data_fine, String alimento){
        ContentValues initialValues = createContentVAlues(id_pasti, cena, colazione, pranzo, spuntino, data_inzio, data_fine, alimento);
        return  database.insertOrThrow(TABELLA_PASTI, null, initialValues);
    }
    //upadate contact
    public boolean updateContactNutrienti(long contactID, String id_pasti, String cena , String colazione, String pranzo, String spuntino, String data_inzio, String data_fine, String alimento){
        ContentValues updateValues = createContentVAlues(id_pasti, cena, colazione, pranzo, spuntino, data_inzio, data_fine, alimento);
        return database.update (TABELLA_PASTI, updateValues,ID_PASTO + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactNutrienti (long contactID) {
        return database.delete(TABELLA_PASTI, ID_PASTO + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllNutrienti() {
        return database.query(TABELLA_PASTI, new String[] {
                ID_PASTO, CENA, COLAZIONE,PRANZO, SPUNTINO, DATA_INIZIO, DATA_FINE, ALIMENTO }, null, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchNutrientiByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_PASTI, new String[] {
                        ID_PASTO, CENA, COLAZIONE,PRANZO, SPUNTINO, DATA_INIZIO, DATA_FINE, ALIMENTO },
                ID_PASTO + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }
}

