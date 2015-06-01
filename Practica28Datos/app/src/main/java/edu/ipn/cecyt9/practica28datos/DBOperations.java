package edu.ipn.cecyt9.practica28datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBOperations {
    private static final String TAG = DBOperations.class.getSimpleName();
    private DBHelper dbHelper;

    public DBOperations(Context context){
        dbHelper = new DBHelper(context);
    }

    public void insert(ContentValues values){
        Log.d(TAG, "Insert " + values);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        try {
            database.insert(DBHelper.TABLE, null, values);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            database.close();
        }
    }
    public boolean getUser(String email, String contra){
        String selection = DBHelper.C_EMAIL + " =? and " + DBHelper.C_PASSWORD + " =? ";
        String args[] = new String[]{email, contra};
        Boolean entra = false;
        SQLiteDatabase dataBase = dbHelper.getReadableDatabase();
        Cursor cursor = dataBase.query(DBHelper.TABLE, null, selection, args, null, null, null);
        if(cursor.moveToFirst()){
            entra = true;
        }
        cursor.close();
        return entra;
    }
}
