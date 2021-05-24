package com.example.messmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {

    public static final String DBName= "Penalties.db";

    public DBHelper2(Context context)
    {
        super(context, "Penalties.db",null,1);
    }
    @Override

    public void onCreate(SQLiteDatabase MyDB2) {
        MyDB2.execSQL("create Table Penalties(registration TEXT primary key, penalty TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB2, int i, int i1) {
        MyDB2.execSQL("drop Table if exists Penalties");


    }

    public Boolean insertData(String registration, String penalty) {
        SQLiteDatabase MyDB2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("registration", registration);
        contentValues.put("penalty", penalty);
        long result = MyDB2.insert("Penalties", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkregistration(String registration){
        SQLiteDatabase MyDB2 = this.getWritableDatabase();
        Cursor cursor = MyDB2.rawQuery("Select * from Penalties where registration = ?", new String[]{registration});
        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }

    public Cursor getPenalty(String registration){

        SQLiteDatabase MyDB2 = this.getReadableDatabase();
        Cursor cursor = MyDB2.rawQuery("Select * from Penalties where registration = ?", new String[]{registration});
        return cursor;
    }

    public Boolean update(String registration,String penalty){
        SQLiteDatabase MyDB2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("registration", registration);
        contentValues.put("penalty", penalty);
        long result=MyDB2.update("Penalties",contentValues,"registration=?",new String[]{registration});
        if(result == -1) return false;
        else
            return true;

    }

}
