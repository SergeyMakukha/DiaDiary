package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.MeasureInjectionLink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 05.08.2017.
 */

public class MeasureInjectionLinkDao {

    public static List<MeasureInjectionLink> get (MeasureInjectionLinkFilter filter) {
        ArrayList<MeasureInjectionLink> linkList = new ArrayList<MeasureInjectionLink>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM measure_injection_link "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MeasureInjectionLink link = new MeasureInjectionLink(cursor.getInt(cursor.getColumnIndex("measure_injection_id"))
                            , cursor.getInt(cursor.getColumnIndex("measure_id"))
                            , cursor.getInt(cursor.getColumnIndex("injection_id"))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_measure_injection_link_id")));
                    linkList.add(link);
                } while(cursor.moveToNext());
            }
        }
        return linkList;
    }

    public static Integer insert (MeasureInjectionLink link){
        return 0;
    }

    public static Integer update (MeasureInjectionLink link){
        return 0;
    }

    public static Integer delete (MeasureInjectionLink link){
        return 0;
    }

}
