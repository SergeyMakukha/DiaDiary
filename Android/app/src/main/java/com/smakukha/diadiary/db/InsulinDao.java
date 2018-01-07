package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.Insulin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 02.08.2017.
 */

public class InsulinDao {

    public InsulinDao() {
        super();
    }

/*    public Measure getById(Integer id){
        SQLiteDatabase db = DBHelper.getDb();
        db.query()
    }*/

    public static List<Insulin> get(InsulinFilter filter) {
        ArrayList<Insulin> insulinList = new ArrayList<Insulin>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM insulin "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Insulin insulin = new Insulin(cursor.getInt(cursor.getColumnIndex("insulin_id"))
                            , cursor.getInt(cursor.getColumnIndex("insulin_type_id"))
                            , cursor.getString(cursor.getColumnIndex("name"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("buy_date")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("start_date")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("end_date")))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_insulin_id")));
                    insulinList.add(insulin);
                } while (cursor.moveToNext());
            }
        }
        return insulinList;
    }

    public static Integer insert(Insulin insulin) {
        return 0;
    }

    public static Integer update(Insulin insulin) {
        return 0;
    }

    public static Integer delete(Insulin insulin) {
        return 0;
    }

}
