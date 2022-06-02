package com.dinhnt.sqliteca3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SanPhamSQLite extends SQLiteOpenHelper {

    public static String DB_NAME = "QLSANPHAM";
    public static int DB_VERSION = 1;

    public SanPhamSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE SANPHAM(id integer primary key autoincrement, " +
                "tensp TEXT, giasp integer, hinhsp TEXT)";
        sqLiteDatabase.execSQL(sql);
        //...
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS  SANPHAM";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
