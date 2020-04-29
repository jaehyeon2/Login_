package com.example.login_practice4;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String tableName = "User_info";

    public DatabaseOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag","db 생성_db가 없을때만 최초로 실행함");
        createTable(db);
    }
    public void createTable(SQLiteDatabase db){
        String sql = "CREATE TABLE " + tableName + "(id text, pw text)";
        try {
            db.execSQL(sql);
        }
        catch (SQLException e){
        }
    }

    public void insertUser(SQLiteDatabase db, String id, String pw){
        Log.i("tag","회원가입을 했을때 실행함");

        db.beginTransaction();
        try {
            String sql = "INSERT INTO " + tableName + "(id, pw)" + "values('"+ id +"', '"+pw+"')";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e){
            e.printStackTrace();

        }
        finally {
            db.endTransaction();
        }
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
