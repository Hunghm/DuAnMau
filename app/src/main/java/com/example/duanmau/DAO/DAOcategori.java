package com.example.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.DatabaseBookManage;

public class DAOcategori {
    public static final String NAME_TABLE ="categori";
    public static final String maTheLoai ="maTheLoai";
    public static final String tenTheLoai ="tenTheLoai";
    public static final String moTa ="moTa";
    public static final String viTri ="viTri";
    public static final String CREAT_TABLE ="create table "+NAME_TABLE+"(" +
            maTheLoai+" text not null primary key, " +
            tenTheLoai+" text, "+
            moTa+" text, "+
            viTri+" int) ";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOcategori(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }


}
