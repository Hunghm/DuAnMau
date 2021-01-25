package com.example.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.DatabaseBookManage;

public class DAOHoaDonChiTiet {
    public static final String NAME_TABLE ="HoaDonChiTiet";
    public static final String maHDCT ="maHDCT";
    public static final String maHoaDon ="maHoaDon";
    public static final String maSach ="maSach";
    public static final String soLuongMua ="soLuongMua";
    public static final String CREAT_TABLE ="create table "+NAME_TABLE+"(" +
            maHDCT+" integer primary key autoincrement, " +
            maHoaDon+" text, "+
            maSach+" text, "+
            soLuongMua+" integer) ";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOHoaDonChiTiet(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }


}
