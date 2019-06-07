package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;


import static com.example.walk4you.util.Constants.CODICE_A_BARRE;
import static com.example.walk4you.util.Constants.ID_ALIMENTI;
import static com.example.walk4you.util.Constants.INGREDIENTI;
import static com.example.walk4you.util.Constants.TABELLA_ALIMENTI;


public class AdapterAggCibo {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterUtente.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterAggCibo(Context context) { this.context = context;}

    public AdapterAggCibo open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String ingredienti ,String codice_barre) {
        ContentValues values = new ContentValues();
        values.put (INGREDIENTI, ingredienti);
        values.put (CODICE_A_BARRE, codice_barre);


        return values;
    }
    // create a contact
    public long createContactCibo (String ingredienti ,String codice_barre){
        ContentValues initialValues = createContentVAlues(ingredienti, codice_barre);
        return  database.insertOrThrow(TABELLA_ALIMENTI, null, initialValues);
    }
    //upadate contact
    public boolean updateContactCibo (long contactID, String ingredienti ,String codice_barre){
        ContentValues updateValues = createContentVAlues(ingredienti, codice_barre);
        return database.update (TABELLA_ALIMENTI, updateValues,ID_ALIMENTI + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactCibo(long contactID) {
        return database.delete(TABELLA_ALIMENTI, ID_ALIMENTI + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllCibo() {
        return database.query(TABELLA_ALIMENTI, new String[] {
               INGREDIENTI, CODICE_A_BARRE}, null, null, null, null, null );
    }
    //fetch contact filtrer by string
    public Cursor fetchCiboByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_ALIMENTI, new String[] {
                        INGREDIENTI, CODICE_A_BARRE,},
                ID_ALIMENTI + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }

}

