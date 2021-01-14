package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnCancel;
    EditText edUser,edPassword;
    TextView textThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnCancel = (Button) findViewById(R.id.btn_Huy);
        btnLogin = (Button) findViewById(R.id.btn_dang_nhap);
        edUser = (EditText) findViewById(R.id.ed_user_name);
        edPassword = (EditText) findViewById(R.id.ed_password);
        textThongBao = (TextView) findViewById(R.id.text_thong_bao);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passWord = edPassword.getText().toString();
                String userName = edUser.getText().toString();
//                if (login(userName,passWord)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
//                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edPassword.setText("");
                edUser.setText("");
            }
        });

    }
    private boolean login(String userName,String passWord){
        textThongBao.setText("");
        if (!userName.trim().equals("hung")||!passWord.trim().equals("1234")){
            textThongBao.setText("User hoặc Password không đúng");
            return  false;
        }
        return true;
    }
    
}