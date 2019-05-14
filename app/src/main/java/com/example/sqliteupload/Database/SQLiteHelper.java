package com.example.sqliteupload.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void queryData(String sql){
    SQLiteDatabase database = getWritableDatabase();
    database.execSQL(sql);
    }
    public void insertData(byte[] image){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?)";

        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindBlob(1, image);

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void updateData( byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);


        statement.bindBlob(1, image);
        statement.bindDouble(2, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
