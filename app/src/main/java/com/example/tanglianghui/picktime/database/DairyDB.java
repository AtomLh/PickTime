package com.example.tanglianghui.picktime.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tanglianghui.picktime.model.Dairy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanglianghui on 16/6/10.
 */
public class DairyDB {
    //数据库名
    public static final String DB_NAME = "my_dairy";
    //数据库版本
    public static final int VERSION = 1;

    private static DairyDB dairyDB;

    private SQLiteDatabase db;

    private DairyDB(Context context){
        DairyOpenHelper dbHelper=new DairyOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

    //获取DairyDB实例
    public synchronized  static DairyDB getInstance(Context context)
    {
        if (dairyDB == null){
            dairyDB = new DairyDB(context);
        }
        return dairyDB;
    }
    //将Diary实例存储到数据库
    public void saveDairy(Dairy dairy){
        if (dairy != null){
            ContentValues values = new ContentValues();
            values.put("date",dairy.getDate());
            values.put("emoji_text",dairy.getEmoji_text());
            values.put("emoji_mark",dairy.getEmoji());
            values.put("activities",dairy.getActivities());
            values.put("descri",dairy.getDescri());
            db.insert("Dairy",null,values);
        }
    }
    public void DeletDairy(int id){
        Integer ID = id;
        db.delete("dairy","id = ?",new String[]{ID.toString()});
    }
    public List<Dairy> loadDairies(){
        List<Dairy>  list = new ArrayList<Dairy>();
        Cursor cursor = db
                .query("Dairy",null,null,null,null,null,null);
        if (cursor.moveToNext()){
            do{
                Dairy dairy  = new Dairy();
                dairy.setId(cursor.getInt(cursor.getColumnIndex("id")));
                dairy.setActivities(cursor.getString(cursor.getColumnIndex("activities")));
                dairy.setDate(cursor.getString(cursor.getColumnIndex("date")));
                dairy.setEmoji(cursor.getInt(cursor.getColumnIndex("emoji_mark")));
                dairy.setDescri(cursor.getString(cursor.getColumnIndex("descri")));
                dairy.setEmoji_text(cursor.getInt(cursor.getColumnIndex("emoji_text")));
                list.add(dairy);
            }while(cursor.moveToNext());
            if (cursor != null){
                cursor.close();
            }

        }
        return list;
    }
}
