package com.example.messmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper4 extends SQLiteOpenHelper {

    public static final String DBName= "Stock.db";

    public DBHelper4(Context context)
    {
        super(context, "Stock.db",null,1);
    }

    @Override


    public void onCreate(SQLiteDatabase MyDB4) {
        MyDB4.execSQL("create Table Stock(item TEXT primary key, quantity FLOAT,price FLOAT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB4, int i, int i1) {
        MyDB4.execSQL("drop Table if exists Stock");

    }

    public Boolean insertData(String item, float quantity,float price) {
        SQLiteDatabase MyDB4 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("quantity", quantity);
        contentValues.put("price",price);
        long result = MyDB4.insert("Stock", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkitem(String item){
        SQLiteDatabase MyDB4 = this.getWritableDatabase();
        Cursor cursor = MyDB4.rawQuery("Select * from Stock where item = ?", new String[]{item});
        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }

    public Cursor getitem(String item){

        SQLiteDatabase MyDB4 = this.getReadableDatabase();
        Cursor cursor = MyDB4.rawQuery("Select * from Stock where item = ?", new String[]{item});
        return cursor;
    }

    public Boolean update(String item, float quantity , float price){
        SQLiteDatabase MyDB4 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("quantity", quantity);
        contentValues.put("price",price);
        long result=MyDB4.update("Stock",contentValues,"item=?",new String[]{item});
        if(result == -1) return false;
        else
            return true;

    }

    public Boolean delete(String item) {
        SQLiteDatabase MyDB4 = this.getWritableDatabase();
        long result = MyDB4.delete("Stock", "item=?", new String[]{item});
        if (result == -1) return false;
        else
            return true;
    }

}
