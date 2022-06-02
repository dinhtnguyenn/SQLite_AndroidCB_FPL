package com.dinhnt.sqliteca3.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dinhnt.sqliteca3.database.SanPhamSQLite;
import com.dinhnt.sqliteca3.model.SanPham;

import java.util.ArrayList;

public class SanphamDAO {
    private SanPhamSQLite sanPhamSQLite;

    public SanphamDAO(Context context) {
        sanPhamSQLite = new SanPhamSQLite(context);
    }

    //lấy danh sách sản phẩm
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sanPhamSQLite.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPham(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public boolean insertProduct(SanPham sanPham) {
        try {
            SQLiteDatabase sqLiteDatabase = sanPhamSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("tensp", sanPham.getTenSP());
            contentValues.put("giasp", sanPham.getGiaSP());
            contentValues.put("hinhsp", sanPham.getHinHSP());
            sqLiteDatabase.insert("SANPHAM", null, contentValues);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
