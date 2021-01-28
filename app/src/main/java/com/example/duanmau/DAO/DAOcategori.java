package com.example.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.DatabaseBookManage;
import com.example.duanmau.Models.Categori;

import java.util.ArrayList;
import java.util.List;

public class DAOcategori {
    public static final String TABLE_NAME = "categori";
    public static final String maTheLoai = "maTheLoai";
    public static final String tenTheLoai = "tenTheLoai";
    public static final String moTa = "moTa";
    public static final String viTri = "viTri";
    public static final String CREAT_TABLE = "create table " + TABLE_NAME + "(" +
            maTheLoai + " text primary key, " +
            tenTheLoai + " text, " +
            moTa + " text, " +
            viTri + " int); ";
    public static final String TAG = "TheLoaiDAO";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOcategori(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserCategori(Categori categori) {
        ContentValues values = new ContentValues();
        values.put(maTheLoai, categori.getMaTheLoai());
        values.put(tenTheLoai, categori.getTenTheLoai());
        values.put(moTa, categori.getMoTa());
        values.put(viTri, categori.getViTri());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<Categori> getAllTheLoai() {
        List<Categori> listCategori = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Categori ee = new Categori();
            ee.setMaTheLoai(c.getString(c.getColumnIndex(maTheLoai)));
            ee.setTenTheLoai(c.getString(c.getColumnIndex(tenTheLoai)));
            ee.setMoTa(c.getString(c.getColumnIndex(moTa)));
            ee.setViTri(c.getInt(c.getColumnIndex(viTri)));
            listCategori.add(ee);
            Log.d("//====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return listCategori;
    }

    public int updateCategori(Categori categori) {
        ContentValues values = new ContentValues();
        values.put(maTheLoai, categori.getMaTheLoai());
        values.put(tenTheLoai, categori.getTenTheLoai());
        values.put(moTa, categori.getMoTa());
        values.put(viTri, categori.getViTri());
        int result = db.update(TABLE_NAME, values, maTheLoai + " =? ", new String[]{categori.getMaTheLoai()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteCategoriById(String maTheLoai) {
        int result = db.delete(TABLE_NAME, this.maTheLoai + " =? ", new String[]{maTheLoai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }


}
