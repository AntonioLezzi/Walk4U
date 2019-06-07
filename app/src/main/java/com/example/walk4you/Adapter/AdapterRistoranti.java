package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.DESCRIZIONE;
import static com.example.walk4you.util.Constants.ID_RISTORANTE;
import static com.example.walk4you.util.Constants.POSIZIONE_GPS_LAT;
import static com.example.walk4you.util.Constants.POSIZIONE_GPS_LONG;
import static com.example.walk4you.util.Constants.TABELLA_RISTORANTI;
import static com.example.walk4you.util.Constants.TIPOLOGIA_RISTORANTE;

public class AdapterRistoranti {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterRistoranti.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterRistoranti(Context context) { this.context = context;}

    public AdapterRistoranti open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String tipologia_ristorante , String descrizione, String posizione_gps_lat, String posizione_gps_long) {
        ContentValues values = new ContentValues();
        values.put (TIPOLOGIA_RISTORANTE, tipologia_ristorante);
        values.put (DESCRIZIONE, descrizione);
        values.put (POSIZIONE_GPS_LAT, posizione_gps_lat);
        values.put (POSIZIONE_GPS_LONG, posizione_gps_long);

        return values;
    }
// create a contact
    public long createContact (String tipologia_ristorante, String descrizione, String posizione_gps_lat, String posizione_gps_long){
        ContentValues initialValues = createContentVAlues(tipologia_ristorante, descrizione, posizione_gps_lat, posizione_gps_long);
        return  database.insertOrThrow(TABELLA_RISTORANTI, null, initialValues);
    }
//upadate contact
    public boolean updateContact (long contactID, String tipologia_ristorante, String descrizione, String posizione_gps_lat, String posizione_gps_long ){
        ContentValues updateValues = createContentVAlues(tipologia_ristorante, descrizione, posizione_gps_lat, posizione_gps_long);
        return database.update (TABELLA_RISTORANTI, updateValues,ID_RISTORANTE + "=" + contactID , null ) >0;
    }
// delete a contact
    public boolean deleteContact (long contactID) {
        return database.delete(TABELLA_RISTORANTI, ID_RISTORANTE + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllRistoranti() {
        return database.query(TABELLA_RISTORANTI, new String[] {
                ID_RISTORANTE, DESCRIZIONE, POSIZIONE_GPS_LAT, POSIZIONE_GPS_LONG,}, null, null, null, null, null);
    }
//fetch contact filtrer by string
    public Cursor fetchRistoranteByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_RISTORANTI, new String[] {
                ID_RISTORANTE, DESCRIZIONE, POSIZIONE_GPS_LAT, POSIZIONE_GPS_LONG,},
        ID_RISTORANTE + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }

}


