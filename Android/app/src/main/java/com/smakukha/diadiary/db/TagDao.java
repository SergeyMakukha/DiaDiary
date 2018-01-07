package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.Measure;
import com.smakukha.diadiary.entity.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 29.07.2017.
 */

public class TagDao {

    public TagDao(){
        super();
    }

/*    public Measure getById(Integer id){
        SQLiteDatabase db = DBHelper.getDb();
        db.query()
    }*/

    public static List<Tag> get (TagFilter filter) {
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM tag "
                + filter.getWhereClause() + ";", null);
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

    public static Integer insert (Tag tag){
        return 0;
    }

    public static Integer update (Tag tag){
        return 0;
    }

    public static Integer delete (Tag tag){
        return 0;
    }

}
