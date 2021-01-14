package com.example.duanmau.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.duanmau.R;

public class AddBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        Spinner spn = (Spinner) findViewById(R.id.spnTheLoai);
        String arrCategori[]={"Cong nghe thong tin","Ke toan","Ngoai ngu","Van hoc","Lich su","Dia ly"};
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrCategori);
        spn.setAdapter(arrayAdapter);
    }
}