package com.example.projectmo.ui.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "polyclinic.db";
    public DBHelper(Context context) {
        super(context, "polyclinic.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(email TEXT primary key, password TEXT, number TEXT, date TEXT, fio TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    public Boolean insertData(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("number", user.getPhone());
        values.put("date", user.getDate());
        values.put("fio", user.getFio());

        long result = db.insert("users", null, values);
        if (result == 1) return false;
        else{
            return true;
        }
    }
    public Boolean checkname(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[]{email, password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public String[] get_user_data(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[]{email, password});
        cursor.moveToPosition(0);

        String my_email = cursor.getString(0);
        String my_number = cursor.getString(2);
        String my_birthday = cursor.getString(3);
        String my_fio = cursor.getString(4);

        String[] user_data = new String[4];

        user_data[0] = my_fio;
        user_data[1] = my_email;
        user_data[2] = my_number;
        user_data[3] = my_birthday;

        return user_data;
    }
}
