package com.example.duanmau.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.duanmau.R;
import com.example.duanmau.adapter.UserAdapter;
import com.example.duanmau.Models.User;

import java.util.ArrayList;

public class NguoiDung extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

//        userList.add(new User(R.drawable.emone,"Hoang Manh Hung","0123456789"));
//        userList.add(new User(R.drawable.emthree,"Hoang Manh Hung","0123456789"));
//        userList.add(new User(R.drawable.emtwo,"Nguyen Thi A","0123456789"));
//        userList.add(new User(R.drawable.emthree,"Hoang Manh Hung","0123456789"));
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(NguoiDung.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        UserAdapter adapter = new UserAdapter(NguoiDung.this, userList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manager_user_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.them:
                startActivity(new Intent(NguoiDung.this, AddUser.class));
                break;
            case R.id.doi_mat_khau:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dang_xuat:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}