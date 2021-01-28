package com.example.duanmau.Bill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.duanmau.R;
import com.example.duanmau.adapter.BillAdapter;

import java.util.ArrayList;
import java.util.Date;

public class HoaDon extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<com.example.duanmau.Models.Bill> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

//        userList.add(new com.example.duanmau.Models.Bill("1","15-2-2021"));
//        userList.add(new com.example.duanmau.Models.Bill("2","15-2-2021"));
//        userList.add(new com.example.duanmau.Models.Bill("3","15-2-2021"));
//        userList.add(new com.example.duanmau.Models.Bill("4","15-2-2021"));
//        userList.add(new com.example.duanmau.Models.Bill("5","15-2-2021"));
//        userList.add(new com.example.duanmau.Models.Bill("6","15-2-2021"));

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(HoaDon.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        BillAdapter adapter = new BillAdapter(HoaDon.this, userList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.them_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.them:
                startActivity(new Intent(HoaDon.this, AddBill.class));
                break;
        }
        return true;
    }
}