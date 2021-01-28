package com.example.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.Bill.HoaDon;
import com.example.duanmau.DatabaseBookManage;
import com.example.duanmau.Models.Bill;
import com.example.duanmau.Models.Book;
import com.example.duanmau.Models.HoaDonChiTiet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOHoaDonChiTiet {
    public static final String TABLE_NAME = "HoaDonChiTiet";
    public static final String maHDCT = "maHDCT";
    public static final String maHoaDon = "maHoaDon";
    public static final String maSach = "maSach";
    public static final String soLuong = "soLuong";
    public static final String CREAT_TABLE = "create table " + TABLE_NAME + "(" +
            maHDCT + " integer primary key autoincrement, " +
            maHoaDon + " text not null, " +
            maSach + " text not null, " +
            soLuong + " integer); ";
    public static final String TAG = "HoaDonChiTietDAO";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAOHoaDonChiTiet(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserHoaDonChiTiet(HoaDonChiTiet hd) {
        ContentValues values = new ContentValues();
        values.put(maHoaDon, hd.getHoaDon().getMaHoaDon());
        values.put(maSach, hd.getSach().getMaSach());
        values.put(soLuong, hd.getSoLuongMua());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        List<HoaDonChiTiet> dsHoaDonChiTiet = new ArrayList<>();
        String sSQL = "SELECT maHDCT, HoaDon.maHoaDon,HoaDon.ngayMua, " +
                " Sach.maSach, Sach.maTheLoai, Sach.tenSach, Sach.tacGia, Sach.NXB," +
                " Sach.giaBia, Sach.soLuong, HoaDonChiTiet.soLuong FROM HoaDonChiTiet INNER JOIN " +
                " HoaDon on HoaDonChiTiet.maHoaDon = HoaDon.maHoaDon INNER JOIN Sach on Sach.maSach " +
                " = HoaDonChiTiet.maSach";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        try {
            while (c.isAfterLast() == false) {
                HoaDonChiTiet ee = new HoaDonChiTiet();
                ee.setMaHDCT(c.getInt(c.getColumnIndex(maHDCT)));
                Bill billLocal = new Bill();
                billLocal.setMaHoaDon(c.getString(c.getColumnIndex(DAObill.maHoaDon)));
                billLocal.setNgayMua(sdf.parse(c.getString(c.getColumnIndex(DAObill.ngayMua))));
                ee.setHoaDon(billLocal);
                Book bookLocal = new Book();
                bookLocal.setMaSach(c.getString(c.getColumnIndex(DAObook.maSach)));
                bookLocal.setMaTheLoai(c.getString(c.getColumnIndex(DAObook.maTheLoai)));
                bookLocal.setTacGia(c.getString(c.getColumnIndex(DAObook.tacGia)));
                bookLocal.setTenSach(c.getString(c.getColumnIndex(DAObook.tenSach)));
                bookLocal.setNXB(c.getString(c.getColumnIndex(DAObook.NXB)));
                bookLocal.setGiaBia(c.getDouble(c.getColumnIndex(DAObook.giaBia)));
                bookLocal.setSoLuong(c.getInt(c.getColumnIndex(DAObook.soLuong)));
                ee.setSach(bookLocal);
                ee.setSoLuongMua(c.getInt(c.getColumnIndex(soLuong)));
                dsHoaDonChiTiet.add(ee);
                Log.d("//=====", ee.toString());
                c.moveToNext();
            }
            c.close();
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
        return dsHoaDonChiTiet;
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTietById(String maHoaDon) {
        List<HoaDonChiTiet> dsHoaDonChiTiet = new ArrayList<>();
        String sSQL = "SELECT maHDCT, HoaDon.maHoaDon,HoaDon.ngayMua, " +
                " Sach.maSach, Sach.maTheLoai, Sach.tenSach, Sach.tacGia, Sach.NXB, Sach.giaBia," +
                " Sach.soLuong, HoaDonChiTiet.soLuong FROM HoaDonChiTiet INNER JOIN HoaDon " +
                " on HoaDonChiTiet.maHoaDon = HoaDon.maHoaDon INNER JOIN Sach on Sach.maSach = HoaDonChiTiet.maSach " +
                " where HoaDonChiTiet.maHoaDon='" + maHoaDon + "'";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        try {
            while (c.isAfterLast() == false) {
                HoaDonChiTiet ee = new HoaDonChiTiet();
                ee.setMaHDCT(c.getInt(c.getColumnIndex(maHDCT)));
                Bill billLocal = new Bill();
                billLocal.setMaHoaDon(c.getString(c.getColumnIndex(DAObill.maHoaDon)));
                billLocal.setNgayMua(sdf.parse(c.getString(c.getColumnIndex(DAObill.ngayMua))));
                ee.setHoaDon(billLocal);
                Book bookLocal = new Book();
                bookLocal.setMaSach(c.getString(c.getColumnIndex(DAObook.maSach)));
                bookLocal.setMaTheLoai(c.getString(c.getColumnIndex(DAObook.maTheLoai)));
                bookLocal.setTacGia(c.getString(c.getColumnIndex(DAObook.tacGia)));
                bookLocal.setTenSach(c.getString(c.getColumnIndex(DAObook.tenSach)));
                bookLocal.setNXB(c.getString(c.getColumnIndex(DAObook.NXB)));
                bookLocal.setGiaBia(c.getDouble(c.getColumnIndex(DAObook.giaBia)));
                bookLocal.setSoLuong(c.getInt(c.getColumnIndex(DAObook.soLuong)));
                ee.setSach(bookLocal);
                ee.setSoLuongMua(c.getInt(c.getColumnIndex(soLuong)));
                dsHoaDonChiTiet.add(ee);
                Log.d("//======", ee.toString());
                c.moveToNext();
            }
            c.close();
        } catch (Exception ex) {
            Log.d(TAG, ex.toString());
        }
        return dsHoaDonChiTiet;
    }

    public int updateHoaDonChiTiet(HoaDonChiTiet hd) {
        ContentValues values = new ContentValues();
        values.put(maHDCT, hd.getMaHDCT());
        values.put(maHoaDon, hd.getHoaDon().getMaHoaDon());
        values.put(maSach, hd.getSach().getMaSach());
        values.put(soLuong, hd.getSoLuongMua());
        int result = db.update(TABLE_NAME, values, maHDCT + " =? ", new String[]{String.valueOf(hd.getMaHDCT())});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteHoaDonChiTIetById(String mahdct) {
        int result = db.delete(TABLE_NAME, maHDCT + " =? ", new String[]{mahdct});
        if (result == 0)
            return -1;
        return 1;
    }

    public boolean checkHoaDon(String maHoaDon) {
        String[] columns = {this.maHoaDon};
        String selection = this.maHoaDon + " =? ";
        String[] selectionArgs = {maHoaDon};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getDoanhThuTheoNgay() {
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongtien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongtien' " +
                " FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon " +
                "INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where strftime('%m',HoaDon.ngayMua) = strftime('%m','now') " +
                " GROUP BY HoaDonChiTiet.maSach)tmp";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            doanhThu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }

    public double getDoanhThuTheoThang() {
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongTien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongTien' " +
                " FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTIet.maHoaDon " +
                " INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where " +
                " strftime('%m', HoaDon.ngayMua) = strftime('%m','now') GROUP BY HoaDonChiTiet.maSach)tmp";
        Cursor c = db.rawQuery(sSQL,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            doanhThu=c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }

    public double getDoanhThuTheoNam(){
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongTien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongTien' " +
                " FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon " +
                " INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where " +
                " strftime('%Y', HoaDon.ngayMua) = strftime('%y','now') GROUP BY HoaDonChiTiet.maSach)tmp ";
        Cursor c = db.rawQuery(sSQL,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            doanhThu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }


}
