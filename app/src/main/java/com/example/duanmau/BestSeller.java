package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.duanmau.adapter.BestSellerAdapter;
import com.example.duanmau.adapter.CategoriAdapter;
import com.example.duanmau.categori.TheLoai;
import com.example.duanmau.context.BestSellerContext;
import com.example.duanmau.context.Categori;

import java.util.ArrayList;

public class BestSeller extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<BestSellerContext> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_seller);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        userList.add(new BestSellerContext("Mã sách:s1","Số lượng: 16"));
        userList.add(new BestSellerContext("Mã sách:s2","Số lượng: 6"));
        userList.add(new BestSellerContext("Mã sách:s3","Số lượng: 10"));
        userList.add(new BestSellerContext("Mã sách:s4","Số lượng: 5"));
        userList.add(new BestSellerContext("Mã sách:s5","Số lượng: 7"));
        userList.add(new BestSellerContext("Mã sách:s6","Số lượng: 3"));

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(BestSeller.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        BestSellerAdapter adapter = new BestSellerAdapter(BestSeller.this, userList);
        recyclerView.setAdapter(adapter);
    }
}