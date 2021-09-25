package com.example.befit_healthandfitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "befit.db";
    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "userid";
    public static final String COL_2 = "fullname";
    public static final String COL_3 = "email";
    public static final String COL_4 = "gender";
    public static final String COL_5 = "password";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addUser(String fullname, String email, String gender, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("email",email);
        contentValues.put("gender",gender);
        contentValues.put("password",password);
        long res = db.insert("user", null, contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String email, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?" + " and "+ COL_5 + "=?";
        String[] selectionArgs = {email,password};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
        {
            return true;
        }
        else
            return false;
    }
}
