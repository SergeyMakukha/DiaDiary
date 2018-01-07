package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.Injection;
import com.smakukha.diadiary.entity.MeasureInjectionLink;
import com.smakukha.diadiary.entity.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 02.08.2017.
 */

public class InjectionDao {

    public InjectionDao(){
        super();
    }

/*    public Measure getById(Integer id){
        SQLiteDatabase db = DBHelper.getDb();
        db.query()
    }*/

    private static List<Tag> getInjectionTag (Integer injectionId) {
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT t.* "
                + "FROM tag t INNER JOIN injection_tag it ON t.tag_id = it.tag_id "
                + "WHERE it.injection_id = " + injectionId.toString() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Tag tag = new Tag(cursor.getInt(cursor.getColumnIndex("tag_id"))
                            , cursor.getString(cursor.getColumnIndex("tag_type"))
                            , cursor.getString(cursor.getColumnIndex("tag_name"))
                            , cursor.getString(cursor.getColumnIndex("description"))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_tag_id")));
                    tagList.add(tag);
                } while(cursor.moveToNext());
            }
        }
        return tagList;
    }

    private static List<MeasureInjectionLink> getMeasureInjectionLink (Integer injectionId) {
        ArrayList<MeasureInjectionLink> linkList = new ArrayList<MeasureInjectionLink>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT l.* "
                + "FROM measure_injection_link l INNER JOIN injection i ON l.injection_id = injection_id "
                + "WHERE i.injection_id = " + injectionId.toString() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MeasureInjectionLink link = new MeasureInjectionLink(cursor.getInt(cursor.getColumnIndex("measure_injection_link_id"))
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

    public static List<Injection> get (InjectionFilter filter){
        ArrayList<Injection> injectionList = new ArrayList<Injection>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM injection "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Injection injection = new Injection(cursor.getInt(cursor.getColumnIndex("injection_id"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("injection_time")))
                            , cursor.getDouble(cursor.getColumnIndex("amount"))
                            , cursor.getInt(cursor.getColumnIndex("insulin_type_id"))
                            , cursor.getInt(cursor.getColumnIndex("insulin_id"))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_injection_id"))
                            , getInjectionTag(cursor.getInt(cursor.getColumnIndex("injection_id")))
                            , getMeasureInjectionLink(cursor.getInt(cursor.getColumnIndex("injection_id"))));
                    injectionList.add(injection);
                } while(cursor.moveToNext());
            }
        }
        return injectionList;
    }

    public static Integer insert (Injection injection){
        return 0;
    }

    public static Integer update (Injection injection){
        return 0;
    }

    public static Integer delete (Injection injection){
        return 0;
    }

}
