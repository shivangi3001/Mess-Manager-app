package com.example.messmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName= "Student.db";

    public DBHelper(Context context)
    {
        super(context, "Student.db",null,1);
    }
    @Override


    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Students(registration TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Students");

    }

    public Boolean insertData(String registration, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("registration", registration);
        contentValues.put("password", password);
        long result = MyDB.insert("Students", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkregistration(String registration){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Students where registration = ?", new String[]{registration});
        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }

    public Boolean checkregistrationpassword(String registration, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Students where registration = ? and password = ?", new String[]{registration,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
