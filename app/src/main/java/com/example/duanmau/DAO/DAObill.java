package com.example.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.DatabaseBookManage;

public class DAObill {
    public static final String NAME_TABLE ="bill";
    public static final String maHoaDon ="maHoaDon";
    public static final String ngayMua ="ngayMua";
    public static final String CREAT_TABLE ="create table "+NAME_TABLE+"(" +
            maHoaDon+" text primary key, " +
            ngayMua+" date) ";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAObill(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }


}
