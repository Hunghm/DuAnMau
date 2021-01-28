package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duanmau.Bill.Bill;
import com.example.duanmau.User.NguoiDung;
import com.example.duanmau.Book.Sach;
import com.example.duanmau.categori.TheLoai;

public class MainActivity extends AppCompatActivity {
    LinearLayout icNguoiDung, icHoaDon, icSach, icTheLoai, icThongKe, icBestSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icNguoiDung = (LinearLayout) findViewById(R.id.linear_user);
        icHoaDon = (LinearLayout) findViewById(R.id.linear_bill);
        icSach = (LinearLayout) findViewById(R.id.linear_book);
        icTheLoai = (LinearLayout) findViewById(R.id.linear_categori);
        icThongKe = (LinearLayout) findViewById(R.id.linear_thong_ke);
        icBestSeller = (LinearLayout) findViewById(R.id.linear_book_hot_buy);

        icNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NguoiDung.class));
            }
        });
        icHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Bill.class));
            }
        });
        icSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sach.class));
            }
        });
        icTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TheLoai.class));
            }
        });
        icThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThongKe.class));
            }
        });
        icBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BestSeller.class));
            }
        });
    }


}