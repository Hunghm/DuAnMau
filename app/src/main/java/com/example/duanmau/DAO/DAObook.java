package com.example.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.DatabaseBookManage;

public class DAObook {
    public static final String NAME_TABLE ="book";
    public static final String maSach ="maSach";
    public static final String maTheLoai ="maTheLoai";
    public static final String tacGia ="tacGia";
    public static final String NXB ="tacGia";
    public static final String giaBia ="giaBia";
    public static final String soLuong ="soLuong";
    public static final String CREAT_TABLE ="create table "+NAME_TABLE+"(" +
            maSach+" text primary key, " +
            maTheLoai+" text, "+
            tacGia+" text, "+
            NXB+" text, "+
            giaBia+" double, "+
            soLuong+" number) ";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAObook(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }

    public void insert(){
        Log.e("","");
    }

}
