package com.example.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.DatabaseBookManage;

public class DAOUser  {
    public static final String NAME_TABLE ="user";
    public static final String userName ="userName";
    public static final String password ="password";
    public static final String phone ="phone";
    public static final String hoTen ="hoTen";
    public static final String CREAT_TABLE ="create table "+NAME_TABLE+"(" +
            userName+" text primary key, " +
            phone+" text, "+
            password+" text, "+
            hoTen+" text) ";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOUser(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }


}
