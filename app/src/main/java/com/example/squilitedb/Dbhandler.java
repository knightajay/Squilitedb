package com.example.squilitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Dbhandler extends SQLiteOpenHelper {
    public Dbhandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String create="CREATE TABLE myemploye(sno INTEGER PRIMARY KEY ,name TEXT ,increment TEXT)";
       db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
String drop= String.valueOf("Drop Table if exist");
db.execSQL(drop, new String[]{"myempolye"});
onCreate(db);
    }
    public void addEmployee(Employ emp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name" , emp.getName());
        values.put("increment" , emp.getIncrement());
        long k=db.insert("myemploye",null , values);
        Log.d("mytag" , Long.toString(k));
        db.close();
    }
    public void getEmploye(int sno){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor=db.query("myemploye" ,new String[]{"sno", "name" , "increment"},"sno?",new String[]{String.valueOf(sno)},null,null,null );
        if(cursor!=null &&cursor.moveToFirst()){
            Log.d("mytag name",cursor.getColumnName(1));
            Log.d("mytag increment",cursor.getColumnName(2));
        }
        else{
            Log.d("mytag", "Some error ocured");
        }
    }
}
