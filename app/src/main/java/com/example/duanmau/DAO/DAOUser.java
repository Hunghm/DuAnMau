package com.example.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.DatabaseBookManage;
import com.example.duanmau.Models.User;
import com.example.duanmau.User.NguoiDung;

import java.util.ArrayList;
import java.util.List;

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
            hoTen+" text); ";
    public static final String TAG = "NguoiDungDAO";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOUser(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }

    public int inserUser(User user){
        ContentValues values = new ContentValues();
        values.put(userName,user.getUserName());
        values.put(password,user.getPassword());
        values.put(phone,user.getPhone());
        values.put(hoTen,user.getHoTen());
        try {
            if (db.insert(NAME_TABLE,null,values)==-1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }

    public List<User> getAllNguoiDung(){
        List<User> listUser = new ArrayList<>();
        Cursor c = db.query(NAME_TABLE,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            User ee = new User();
            ee.setUserName(c.getString(c.getColumnIndex(userName)));
            ee.setPassword(c.getString(c.getColumnIndex(password)));
            ee.setPhone(c.getString(c.getColumnIndex(phone)));
            ee.setHoTen(c.getString(c.getColumnIndex(hoTen)));
            listUser.add(ee);
            Log.d("//=====",ee.toString());
            c.moveToNext();
        }
        c.close();
        return listUser;
    }

    public int updateUser(User user){
        ContentValues values = new ContentValues();
        values.put(userName,user.getUserName());
        values.put(password,user.getPassword());
        values.put(phone,user.getPhone());
        values.put(hoTen,user.getHoTen());
        int result = db.update(NAME_TABLE,values,userName+" = ? ",new String[]{user.getUserName()});
        if (result==0){
            return -1;
        }
        return 1;
    }

    public int changePasswordUser(User user){
        ContentValues values = new ContentValues();
        values.put(userName,user.getUserName());
        values.put(password,user.getPassword());
        int result= db.update(NAME_TABLE,values,userName+" = ? ",new String[]{user.getUserName()});
        if (result==0){
            return -1;
        }
        return 1;
    }

    public int updateInfoUser(String userName, String phone, String name){
        ContentValues values = new ContentValues();
        values.put(this.phone,phone);
        values.put(this.hoTen,name);
        int result = db.update(NAME_TABLE,values,this.userName+" =? ",new String[]{userName});
        if (result==0){
            return -1;
        }
        return 1;
    }

    public int deleteUserByID(String userName){
        int result = db.delete(NAME_TABLE,this.userName+" =? ",new String[]{userName});
        if (result==0){
            return -1;
        }
        return 1;
    }

    public int checkLogin(String userName, String password){
        int result = db.delete(NAME_TABLE,this.userName+" =? and "+this.password+" =? ",new String[]{userName,password});
        if (result==0){
            return -1;
        }
        return 1;
    }

}
