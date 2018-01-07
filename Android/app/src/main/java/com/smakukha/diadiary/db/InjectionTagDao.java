package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.InjectionTag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 05.08.2017.
 */

public class InjectionTagDao {

    public static List<InjectionTag> get (InjectionTagFilter filter) {
        ArrayList<InjectionTag> injectionTagList = new ArrayList<InjectionTag>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM injection_tag "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    InjectionTag injectionTag = new InjectionTag(cursor.getInt(cursor.getColumnIndex("injection_tag_id"))
                            , cursor.getInt(cursor.getColumnIndex("tag_id"))
                            , cursor.getInt(cursor.getColumnIndex("injection_id"))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_injection_tag_id")));
                    injectionTagList.add(injectionTag);
                } while(cursor.moveToNext());
            }
        }
        return injectionTagList;
    }

    public static Integer insert (InjectionTag injectionTag){
        return 0;
    }

    public static Integer update (InjectionTag injectionTag){
        return 0;
    }

    public static Integer delete (InjectionTag injectionTag){
        return 0;
    }

}
