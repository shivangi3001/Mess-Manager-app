package com.example.messmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper1 extends SQLiteOpenHelper{

    public static final String DBName= "AttendanceTABLE.db";

    public DBHelper1(Context context)
    {
        super(context, "AttendanceTABLE.db",null,1);
    }
    @Override

    public void onCreate(SQLiteDatabase MyDB1) {
        MyDB1.execSQL("create Table AttendanceTABLE(registration TEXT , status TEXT,date TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB1, int i, int i1) {
        MyDB1.execSQL("drop Table if exists AttendanceTABLE");


    }

    public Boolean insertData(String registration, String status,String date) {
        SQLiteDatabase MyDB1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("registration", registration);
        contentValues.put("status", status);
        contentValues.put("date",date);

        long result = MyDB1.insert("AttendanceTABLE", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkregistration(String registration,String date){
        SQLiteDatabase MyDB1 = this.getWritableDatabase();
        Cursor cursor = MyDB1.rawQuery("Select * from AttendanceTABLE where registration=? and date=?", new String[]{registration,date});


        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }

    public Cursor getPlateCount(String date){

        String status="Yes";
        SQLiteDatabase MyDB1 = this.getReadableDatabase();
        Cursor cursor = MyDB1.rawQuery("Select * from AttendanceTABLE where date = ? and status = ?", new String[]{date,status});
        return cursor;
    }
}
