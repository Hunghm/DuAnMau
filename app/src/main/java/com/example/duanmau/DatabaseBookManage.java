package com.example.duanmau;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duanmau.DAO.DAOHoaDonChiTiet;
import com.example.duanmau.DAO.DAOUser;
import com.example.duanmau.DAO.DAObill;
import com.example.duanmau.DAO.DAObook;
import com.example.duanmau.DAO.DAOcategori;

public class DatabaseBookManage extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String nameDB = "dbBookManage";

    public DatabaseBookManage(@Nullable Context context) {
        super(context, nameDB, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DAOUser.CREAT_TABLE);
        db.execSQL(DAOcategori.CREAT_TABLE);
        db.execSQL(DAObook.CREAT_TABLE);
        db.execSQL(DAObill.CREAT_TABLE);
        db.execSQL(DAOHoaDonChiTiet.CREAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
