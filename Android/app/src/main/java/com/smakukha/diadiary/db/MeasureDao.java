package com.smakukha.diadiary.db;

/**
 * Created by mac on 29.07.2017.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.smakukha.diadiary.entity.*;

public class MeasureDao {

    public MeasureDao(){
        super();
    }

/*    public Measure getById(Integer id){
        SQLiteDatabase db = DBHelper.getDb();
        db.query()
    }*/

    private static List<Tag> getMeasureTag (Integer measureId) {
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT t.* "
                + "FROM tag t INNER JOIN measure_tag mt ON t.tag_id = mt.tag_id "
                + "WHERE mt.measure_id = " + measureId.toString() + ";", null);
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

    public static List<Measure> get (MeasureFilter filter){
        ArrayList<Measure> measureList = new ArrayList<Measure>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM measure "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Measure measure = new Measure(cursor.getInt(cursor.getColumnIndex("measure_id"))
                    , new Date(cursor.getLong(cursor.getColumnIndex("measure_time")))
                    , cursor.getDouble(cursor.getColumnIndex("amount"))
                    , cursor.getString(cursor.getColumnIndex("measure_unit"))
                    , cursor.getString(cursor.getColumnIndex("comment"))
                    , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                    , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                    , cursor.getInt(cursor.getColumnIndex("server_measure_id"))
                    , getMeasureTag(cursor.getInt(cursor.getColumnIndex("measure_id"))));
                    measureList.add(measure);
                } while(cursor.moveToNext());
            }
        }
        return measureList;
    }

    public static Integer insert (Measure measure){
        StringBuilder sql = new StringBuilder();
        SQLiteDatabase db = DBHelper.getDb();
        sql.append("INSERT INTO measure (measure_time, amount, measure_unit, "
                + "comment, created, changed)"
                + "VALUES("
                + SQLUtils.getDateValue(measure.getMeasureTime()) + ", "
                + SQLUtils.getDoubleValue(measure.getAmount()) + ", "
                + SQLUtils.getStringValue(measure.getMeasureUnit()) + ", "
                + SQLUtils.getStringValue(measure.getComment()) + ", "
                + SQLUtils.getDateValue(measure.getCreated()) + ", "
                + SQLUtils.getDateValue(measure.getChanged())
                + ");");
        //db.insertWithOnConflict()
        return 0;
    }

    public static Integer update (Measure measure){
        return 0;
    }

    public static Integer delete (Measure measure){
        return 0;
    }
}
