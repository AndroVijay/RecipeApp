package com.example.vijay.recipeapp.vijay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by vijay on 17-02-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="fooddb";
    private static final String TABLE_NAME="recipe";
    private static final String  CREATE_TABLE=" CREATE TABLE recipe (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, discription TEXT NOT NULL, image BLOB);";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void  insertData(String name, String discription, byte[] image)
    {
        SQLiteDatabase database=getWritableDatabase();
        String sql="insert into recipe values (null, ?, ?, ?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,discription);
        statement.bindBlob(3,image);
        statement.executeInsert();

    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);

    }
}
