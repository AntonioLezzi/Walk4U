package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import static com.example.walk4you.util.Constants.GRASSI_SATURI;
import static com.example.walk4you.util.Constants.FIBRE;
import static com.example.walk4you.util.Constants.ID_NUTRIENTI;
import static com.example.walk4you.util.Constants.PROTEINE;
import static com.example.walk4you.util.Constants.POTASSIO;
import static com.example.walk4you.util.Constants.FERRO;
import static com.example.walk4you.util.Constants.VITAMINA_A;
import static com.example.walk4you.util.Constants.VITAMINA_C;
import static com.example.walk4you.util.Constants.SODIO;
import static com.example.walk4you.util.Constants.TABELLA_NUTRIENTI;


public class AdapterNutrienti {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterNutrienti.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterNutrienti(Context context) { this.context = context;}

    public AdapterNutrienti open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentVAlues (String Grassi_saturi , String fibre , String proteine, String potassio, String ferro, String vitamia_A, String vitamina_C, String sodio) {
        ContentValues values = new ContentValues();
        values.put (GRASSI_SATURI, Grassi_saturi);
        values.put (FIBRE, fibre);
        values.put (PROTEINE, proteine);
        values.put(POTASSIO, potassio );
        values.put (FERRO, ferro);
        values.put (VITAMINA_A, vitamia_A);
        values.put (VITAMINA_C, vitamina_C);
        values.put (SODIO, sodio);


        return values;
    }
    // create a contact
    public long createContactNutrienti (String Grassi_saturi , String fibre , String proteine, String potassio, String ferro, String vitamia_A, String vitamina_C, String sodio){
        ContentValues initialValues = createContentVAlues(Grassi_saturi, fibre, proteine, potassio, ferro, vitamia_A, vitamina_C, sodio);
        return  database.insertOrThrow(TABELLA_NUTRIENTI, null, initialValues);
    }
    //upadate contact
    public boolean updateContactNutrienti(long contactID, String Grassi_saturi , String fibre , String proteine, String potassio, String ferro, String vitamia_A, String vitamina_C, String sodio){
        ContentValues updateValues = createContentVAlues(Grassi_saturi, fibre, proteine, potassio, ferro, vitamia_A, vitamina_C, sodio);
        return database.update (TABELLA_NUTRIENTI, updateValues,ID_NUTRIENTI + "=" + contactID , null ) >0;
    }
    // delete a contact
    public boolean deleteContactNutrienti (long contactID) {
        return database.delete(TABELLA_NUTRIENTI, ID_NUTRIENTI + "="+ contactID, null)>0;
    }


    //fetch all contacts
    public Cursor fetchAllNutrienti() {
        return database.query(TABELLA_NUTRIENTI, new String[] {
                ID_NUTRIENTI, GRASSI_SATURI, FIBRE, PROTEINE, FERRO, VITAMINA_A, VITAMINA_C, SODIO}, null, null, null, null, null, null);
    }
    //fetch contact filtrer by string
    public Cursor fetchNutrientiByFilter(String filter) {
        Cursor mCursor = database.query (true, TABELLA_NUTRIENTI, new String[] {
                        ID_NUTRIENTI, GRASSI_SATURI, FIBRE, PROTEINE, FERRO, VITAMINA_A, VITAMINA_C, SODIO },
                ID_NUTRIENTI + "like '%" + filter + "%'", null, null, null, null, null);
        return mCursor;
    }
}
