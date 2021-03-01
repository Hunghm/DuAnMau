package com.example.duanmau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duanmau.R;
import com.example.duanmau.adapter.HoaDonChiTietAdapter;
import com.example.duanmau.dao.HoaDonChiTietDAO;
import com.example.duanmau.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietActivity extends AppCompatActivity {
    public List<HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    HoaDonChiTietAdapter adapter = null;
    HoaDonChiTietDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        setContentView(R.layout.activity_hoa_don_chi_tiet);
        lvCart = findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(HoaDonChiTietActivity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT = hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new HoaDonChiTietAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}