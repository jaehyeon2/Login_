package com.example.login_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button login_btn, signup_btn;
    EditText login_ID, login_PW;
    String ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        login_btn = findViewById(R.id.login);
        signup_btn = findViewById(R.id.signup);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_ID = findViewById(R.id.login_ID);
                login_PW = findViewById(R.id.login_PW);
                ID = login_ID.getText().toString();
                PW = login_PW.getText().toString();
                if(ID.length() == 0 || PW.length() == 0) {
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    //id를 DB에 검색해본다. 그에 다른 패스워드를 다른 변수에 넣어둔다.
                    //일치하면 finish();
                    //불일치 시 Toast로 일치하지 않음 문국를 내보냄.
                }
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);

            }
        });
    }
}