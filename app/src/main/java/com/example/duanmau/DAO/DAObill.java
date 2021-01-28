package com.example.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.Bill.HoaDon;
import com.example.duanmau.DatabaseBookManage;
import com.example.duanmau.Models.Bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAObill {
    public static final String TABLE_NAME ="bill";
    public static final String maHoaDon ="maHoaDon";
    public static final String ngayMua ="ngayMua";
    public static final String CREAT_TABLE ="create table "+TABLE_NAME+"(" +
            maHoaDon+" text primary key, " +
            ngayMua+" date); ";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static final String TAG = "HoaDonDAO";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAObill(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db=dbHelper.getWritableDatabase();
    }

    public int inserBill(Bill bill){
        ContentValues values = new ContentValues();
        values.put(maHoaDon,bill.getMaHoaDon());
        values.put(ngayMua,sdf.format(bill.getNgayMua()));
        try {
            if (db.insert(TABLE_NAME,null,values)==-1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }

    public List<Bill> getAllBill() throws ParseException {
        List<Bill> listBill = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Bill ee = new Bill();
            ee.setMaHoaDon(c.getString(c.getColumnIndex(maHoaDon)));
            ee.setNgayMua(sdf.parse(c.getString(c.getColumnIndex(ngayMua))));
            listBill.add(ee);
            Log.d("//=====",ee.toString());
            c.moveToNext();
        }
        c.close();
        return listBill;
    }

    public int updateHoaDon(Bill bill){
        ContentValues values = new ContentValues();
        values.put(maHoaDon,bill.getMaHoaDon());
        values.put(ngayMua,bill.getNgayMua().toString());
        int result = db.update(TABLE_NAME,values,maHoaDon+" =? ",new String[]{bill.getMaHoaDon()});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int deleteBillById(String mahoadon){
        int result = db.delete(TABLE_NAME,maHoaDon+" =? ",new String[]{mahoadon});
        if (result == 0){
            return -1;
        }
        return 1;
    }

}
