package com.smakukha.diadiary.db;

/**
 * Created by mac on 28.07.2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.smakukha.diadiary.db.SQLTemplate;

public class DBHelper extends SQLiteOpenHelper {

    final static String LOG_TAG = "[DiaDiary]";
    private static DBHelper dbHelper;
    private static SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, "DiaDiaryDB", null, 1);
        db = this.getWritableDatabase();
    }

    public static DBHelper getDBHelper (Context context) {
        if (dbHelper == null) {
            Log.d(LOG_TAG, "Static method...");
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "Creatng tables ...");
        db.execSQL(SQLTemplate.createTag);
        Log.d(LOG_TAG, "Table tag created.");
        db.execSQL(SQLTemplate.createMeasure);
        Log.d(LOG_TAG, "Table measure created.");
        db.execSQL(SQLTemplate.createMeasureTag);
        Log.d(LOG_TAG, "Table measure_tag created.");
        db.execSQL(SQLTemplate.addTag);
        db.execSQL(SQLTemplate.addMeasure);
        db.execSQL(SQLTemplate.addMeasureTag);
        Log.d(LOG_TAG, "Sample rows inserted.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void finalize () {
        this.close();
    }
}
