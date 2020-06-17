package com.example.hm_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {

    private int id;
    private String title;

    EditText phoneView;
    EditText passwordView;
    Button loginBtnView;
    CheckBox checkBoxView;


    String phoneInput;
    String passwordInput;
    boolean iScheck =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        id = getIntent().getIntExtra("id",0);
        title = getIntent().getStringExtra("title");
        TextView titleView = findViewById(R.id.title);
        titleView.setText(title);


        phoneView = findViewById(R.id.phone_view);
        passwordView = findViewById(R.id.password_view);
        checkBoxView = findViewById(R.id.checkbox_view);
        loginBtnView = findViewById(R.id.login_btn_view);


        loginBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneInput = phoneView.getText().toString();
                passwordInput = passwordView.getText().toString();
                iScheck = checkBoxView.isChecked();
                if(iScheck){

                }else{
                    Toast.makeText(LogActivity.this,"没有勾选协议",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
