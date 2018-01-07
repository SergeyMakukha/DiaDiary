package com.smakukha.diadiary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smakukha.diadiary.entity.InsulinType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 01.08.2017.
 */

public class InsulinTypeDao {

    public InsulinTypeDao(){
        super();
    }

/*    public Measure getById(Integer id){
        SQLiteDatabase db = DBHelper.getDb();
        db.query()
    }*/

    public static List<InsulinType> get (InsulinTypeFilter filter) {
        ArrayList<InsulinType> insulinTypeList = new ArrayList<InsulinType>();
        SQLiteDatabase db = DBHelper.getDb();
        Cursor cursor = db.rawQuery("SELECT * "
                + "FROM insulin_type "
                + filter.getWhereClause() + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    InsulinType insulinType = new InsulinType(cursor.getInt(cursor.getColumnIndex("insulin_type_id"))
                            , cursor.getString(cursor.getColumnIndex("name"))
                            , cursor.getString(cursor.getColumnIndex("comment"))
                            , new Date(cursor.getLong(cursor.getColumnIndex("created")))
                            , new Date(cursor.getLong(cursor.getColumnIndex("changed")))
                            , cursor.getInt(cursor.getColumnIndex("server_insulin_type_id")));
                    insulinTypeList.add(insulinType);
                } while(cursor.moveToNext());
            }
        }
        return insulinTypeList;
    }

    public static Integer insert (InsulinType insulinType){
        return 0;
    }

    public static Integer update (InsulinType insulinType){
        return 0;
    }

    public static Integer delete (InsulinType insulinType){
        return 0;
    }

}
