package com.example.duanmau.Book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.duanmau.Bill.AddBill;
import com.example.duanmau.Bill.HoaDon;
import com.example.duanmau.R;
import com.example.duanmau.adapter.BillAdapter;
import com.example.duanmau.adapter.BookAdapter;
import com.example.duanmau.context.Bill;
import com.example.duanmau.context.Book;

import java.util.ArrayList;

public class Sach extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Book> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        userList.add(new Book("Tin hoc co so","100"));
        userList.add(new Book("Tin hoc van phong","100"));
        userList.add(new Book("Java 1","100"));
        userList.add(new Book("Java 2","100"));
        userList.add(new Book("Java 3","100"));
        userList.add(new Book("Co so du lieu","100"));
        userList.add(new Book("Lap trinh Android","100"));
        userList.add(new Book("Lap trinh C++ ","100"));
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(Sach.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        BookAdapter adapter = new BookAdapter(Sach.this, userList);
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
                startActivity(new Intent(Sach.this, AddBook.class));
                break;
        }
        return true;
    }
}