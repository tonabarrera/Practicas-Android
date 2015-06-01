package edu.ipn.cecyt9.practica28datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_NAME = "reservas.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE = "usuarios";
    public static final String C_ID = BaseColumns._ID;
    public static final String C_EMAIL = "user_email";
    public static final String C_PASSWORD = "user_password";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE + " (" + C_ID + " integer primary key autoincrement, "
                + C_EMAIL + " text, " + C_PASSWORD + " text)";
        db.execSQL(sql);
        Log.i(TAG, sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE);
        Log.d(TAG, "Actualizada");
        onCreate(db);
    }
}
