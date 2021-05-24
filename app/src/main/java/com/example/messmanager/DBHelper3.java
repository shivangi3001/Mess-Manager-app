package com.example.messmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper3 extends SQLiteOpenHelper {

    public static final String DBName= "Caterers.db";

    public DBHelper3(Context context)
    {
        super(context, "Caterers.db",null,1);
    }

    @Override


    public void onCreate(SQLiteDatabase MyDB3) {
        MyDB3.execSQL("create Table Caterers(name TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB3, int i, int i1) {
        MyDB3.execSQL("drop Table if exists Caterers");

    }

    public Boolean insertData(String name, String password) {
        SQLiteDatabase MyDB3 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        long result = MyDB3.insert("Caterers", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkname(String name){
        SQLiteDatabase MyDB3 = this.getWritableDatabase();
        Cursor cursor = MyDB3.rawQuery("Select * from Caterers where name = ?", new String[]{name});
        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }


    public Boolean checknamepassword(String name, String password){
        SQLiteDatabase MyDB3 = this.getWritableDatabase();
        Cursor cursor = MyDB3.rawQuery("Select * from Caterers where name = ? and password = ?", new String[]{name,password});


        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }
}
