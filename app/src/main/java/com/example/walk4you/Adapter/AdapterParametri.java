package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.BATTITO_CARDIACO;
import static com.example.walk4you.util.Constants.ID_PARAMETRI;
import static com.example.walk4you.util.Constants.SATURAZIONE_OSSIGENO;
import static com.example.walk4you.util.Constants.TABELLA_PARAMETRI;


public class AdapterParametri {

    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterParametri.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterParametri(Context context) { this.context = context;}

    public AdapterParametri open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String id_parametri , String battito_cardiaco , String saturazione_ossigeno) {
        ContentValues values = new ContentValues();
        values.put (ID_PARAMETRI, id_parametri);
        values.put (BATTITO_CARDIACO, battito_cardiaco);
        values.put (SATURAZIONE_OSSIGENO, saturazione_ossigeno);


        return values;
    }
    // create a contact
    public long createContactNutrienti (String id_parametri , String battito_cardiaco , String saturazione_ossigeno){
        ContentValues initialValues = createContentVAlues(id_parametri, battito_cardiaco, saturazione_ossigeno);
        return  database.insertOrThrow(TABELLA_PARAMETRI, null, initialValues);
    }
    //upadate contact
    public boolean updateContactNutrienti(long contactID, String id_parametri , String battito_cardiaco , String saturazione_ossigeno){
        ContentValues updateValues = createContentVAlues(id_parametri, battito_cardiaco, saturazione_ossigeno);
        return database.update (TABELLA_PARAMETRI, updateValues,ID_PARAMETRI + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactNutrienti (long contactID) {
        return database.delete(TABELLA_PARAMETRI, ID_PARAMETRI + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllNutrienti() {
        return database.query(TABELLA_PARAMETRI, new String[] {
                ID_PARAMETRI, BATTITO_CARDIACO, SATURAZIONE_OSSIGENO }, null, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchNutrientiByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_PARAMETRI, new String[] {
                        ID_PARAMETRI, BATTITO_CARDIACO, SATURAZIONE_OSSIGENO },
                ID_PARAMETRI + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }
}

