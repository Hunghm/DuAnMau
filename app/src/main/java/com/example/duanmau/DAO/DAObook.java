package com.example.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.DatabaseBookManage;
import com.example.duanmau.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class DAObook {
    public static final String TABLE_NAME = "book";
    public static final String maSach = "maSach";
    public static final String maTheLoai = "maTheLoai";
    public static final String tenSach = "tenSach";
    public static final String tacGia = "tacGia";
    public static final String NXB = "tacGia";
    public static final String giaBia = "giaBia";
    public static final String soLuong = "soLuong";
    public static final String CREAT_TABLE = "create table " + TABLE_NAME + "(" +
            maSach + " text primary key, " +
            maTheLoai + " text, " +
            tenSach + " text, " +
            tacGia + " text, " +
            NXB + " text, " +
            giaBia + " double, " +
            soLuong + " number); ";
    public static final String TAG = "SachDAO";
    private SQLiteDatabase db;
    private DatabaseBookManage dbHelper;

    public DAObook(Context context) {
        dbHelper = new DatabaseBookManage(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserBook(Book book) {
        ContentValues values = new ContentValues();
        values.put(maSach, book.getMaSach());
        values.put(maTheLoai, book.getMaTheLoai());
        values.put(tenSach, book.getTenSach());
        values.put(tacGia, book.getTacGia());
        values.put(NXB, book.getNXB());
        values.put(giaBia, book.getGiaBia());
        values.put(soLuong, book.getSoLuong());
        if (checkPrimaryKey(book.getMaSach())) {
            int result = db.update(TABLE_NAME, values, maSach + " =? ", new String[]{book.getMaSach()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
        return 1;
    }

    public List<Book> getAllBook() {
        List<Book> listBook = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Book book = new Book();
            book.setMaSach(c.getString(c.getColumnIndex(maSach)));
            book.setMaTheLoai(c.getString(c.getColumnIndex(maTheLoai)));
            book.setTenSach(c.getString(c.getColumnIndex(tenSach)));
            book.setTacGia(c.getString(c.getColumnIndex(tacGia)));
            book.setNXB(c.getString(c.getColumnIndex(NXB)));
            book.setGiaBia(c.getDouble(c.getColumnIndex(giaBia)));
            book.setSoLuong(c.getInt(c.getColumnIndex(soLuong)));
            listBook.add(book);
            Log.d("//======", book.toString());
            c.moveToNext();
        }
        c.close();
        return listBook;
    }

    public int updateBook(Book book) {
        ContentValues values = new ContentValues();
        values.put(maSach, book.getMaSach());
        values.put(maTheLoai, book.getMaTheLoai());
        values.put(tenSach, book.getTenSach());
        values.put(tacGia, book.getTacGia());
        values.put(NXB, book.getNXB());
        values.put(giaBia, book.getGiaBia());
        values.put(soLuong, book.getSoLuong());
        int result = db.update(TABLE_NAME, values, maSach + " =? ", new String[]{book.getMaSach()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteSachById(String maSach) {
        int result = db.delete(TABLE_NAME, this.maSach + " =? ", new String[]{maSach});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    private boolean checkPrimaryKey(String strPrimaryKey) {
        String[] columns = {maSach};
        String selection = maSach + " =? ";
        String[] selectionArgs = {strPrimaryKey};
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

    public Book checkBook(String strPrimaryKey) {
        Book book = new Book();
        String[] columns = {maSach};
        String selection = maSach + " =? ";
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            while (c.isAfterLast() == false) {
                book.setMaSach(c.getString(c.getColumnIndex(maSach)));
                book.setMaTheLoai(c.getString(c.getColumnIndex(maTheLoai)));
                book.setTenSach(c.getString(c.getColumnIndex(tenSach)));
                book.setTacGia(c.getString(c.getColumnIndex(tacGia)));
                book.setNXB(c.getString(c.getColumnIndex(NXB)));
                book.setGiaBia(c.getDouble(c.getColumnIndex(giaBia)));
                book.setSoLuong(c.getInt(c.getColumnIndex(soLuong)));
                Log.d("//=====", book.toString());
                break;
            }
            c.close();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookById(String maSach) {
        Book book = null;
        String selection = this.maSach + " =? ";
        String[] selectionArgs = {maSach};
        Cursor c = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        Log.d("getSachById", "====>" + c.getCount());
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            book = new Book();
            book.setMaSach(c.getString(c.getColumnIndex(maSach)));
            book.setMaTheLoai(c.getString(c.getColumnIndex(maTheLoai)));
            book.setTenSach(c.getString(c.getColumnIndex(tenSach)));
            book.setTacGia(c.getString(c.getColumnIndex(tacGia)));
            book.setNXB(c.getString(c.getColumnIndex(NXB)));
            book.setGiaBia(c.getDouble(c.getColumnIndex(giaBia)));
            book.setSoLuong(c.getInt(c.getColumnIndex(soLuong)));
            break;
        }
        c.close();
        return book;
    }

    public List<Book> getBookTop10(String month) {
        List<Book> listBook = new ArrayList<>();
        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        String sSQL = "SELECT " + maSach + " , SUM( " + soLuong + " ) as " + soLuong + " FROM " + DAOHoaDonChiTiet.TABLE_NAME + " " +
                " INNER JOIN " + DAObill.TABLE_NAME + " ON " + DAObill.TABLE_NAME + ".maHoaDon = HoaDonChiTiet.maHoaDon WHERE " +
                " strftime('%m' ," + DAObill.TABLE_NAME + ".ngayMua) = '" + month + "' " +
                " GROUP BY maSach ORDER BY soLuong DESC LIMIT 10 ";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Log.d("//=====", c.getString(0));
            Book book = new Book();
            book.setMaSach(c.getString(0));
            book.setSoLuong(c.getInt(1));
            book.setGiaBia(0);
            book.setMaTheLoai("");
            book.setTenSach("");
            book.setTacGia("");
            book.setNXB("");
            listBook.add(book);
            c.moveToNext();
        }
        c.close();
        return listBook;
    }
}
