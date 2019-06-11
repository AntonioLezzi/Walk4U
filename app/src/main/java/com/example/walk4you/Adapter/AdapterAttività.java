package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.DATA_FINE_ATT;
import static com.example.walk4you.util.Constants.DATA_INIZIO_ATT;
import static com.example.walk4you.util.Constants.ID_ATTIVITA;
import static com.example.walk4you.util.Constants.KCAL_BRUCIATE;
import static com.example.walk4you.util.Constants.KM;
import static com.example.walk4you.util.Constants.NUMERO_PASSO;
import static com.example.walk4you.util.Constants.ORE_SONNO;
import static com.example.walk4you.util.Constants.TABELLA_ATTIVITA;


public class AdapterAttività {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterAttività.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterAttività(Context context) { this.context = context;}

    public AdapterAttività open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String numero_passi , String data_inizio, String data_fine, String ore_sonno, String km, String kcal_bruciate) {
        ContentValues values = new ContentValues();
        values.put (ID_ATTIVITA, "id_attività");
        values.put (NUMERO_PASSO, "numero_passi");
        values.put (DATA_INIZIO_ATT, "data_inizio");
        values.put (DATA_FINE_ATT, "data_fine");
        values.put (ORE_SONNO, "ore_sonno");
        values.put (KM, "km");
        values.put (KCAL_BRUCIATE, "kcal_bruciate");


        return values;
    }
    // create a contact
    public long createContactNutrienti (String id_attività , String numero_passi , String data_inizio, String data_fine, String ore_sonno, String km, String kcal_bruciate){
        ContentValues initialValues = createContentVAlues(numero_passi, data_inizio, data_fine, ore_sonno, km, kcal_bruciate);
        return  database.insertOrThrow(TABELLA_ATTIVITA, null, initialValues);
    }
    //upadate contact
    public boolean updateContactNutrienti(long contactID, String numero_passi , String data_inizio, String data_fine, String ore_sonno, String km, String kcal_bruciate){
        ContentValues updateValues = createContentVAlues(numero_passi, data_inizio, data_fine, ore_sonno, km, kcal_bruciate );
        return database.update (TABELLA_ATTIVITA, updateValues,ID_ATTIVITA + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactNutrienti (long contactID) {
        return database.delete(TABELLA_ATTIVITA, ID_ATTIVITA + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllNutrienti() {
        return database.query(TABELLA_ATTIVITA, new String[] {
                ID_ATTIVITA, NUMERO_PASSO, DATA_INIZIO_ATT, DATA_FINE_ATT, ORE_SONNO, KM, KCAL_BRUCIATE }, null, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchNutrientiByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_ATTIVITA, new String[] {
                        ID_ATTIVITA, NUMERO_PASSO, DATA_INIZIO_ATT, DATA_FINE_ATT, ORE_SONNO, KM, KCAL_BRUCIATE },
                ID_ATTIVITA + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }
}

