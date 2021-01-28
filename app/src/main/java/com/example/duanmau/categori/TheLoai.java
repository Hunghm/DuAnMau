package com.example.duanmau.categori;

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
import com.example.duanmau.adapter.CategoriAdapter;
import com.example.duanmau.Models.Categori;

import java.util.ArrayList;

public class TheLoai extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Categori> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        userList.add(new Categori("1","Công nghệ thông tin"));
        userList.add(new Categori("2","Kế toán"));
        userList.add(new Categori("3","Ngoại ngữ"));
        userList.add(new Categori("4","Văn học"));
        userList.add(new Categori("5","Lịch sử"));
        userList.add(new Categori("6","Địa lí"));

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(TheLoai.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        CategoriAdapter adapter = new CategoriAdapter(TheLoai.this, userList);
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
                startActivity(new Intent(TheLoai.this, AddCategori.class));
                break;

        }
        return true;
    }
}