package com.example.login_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button signup_fin_btn;
    EditText signup_NM, signup_ID, signup_PW, signup_PW2;
    String name, id, pw, pw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        signup_fin_btn = findViewById(R.id.signup_fin);
        signup_fin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);*/
                signup_NM = findViewById(R.id.signup_Name);
                signup_ID = findViewById(R.id.signup_ID);
                signup_PW = findViewById(R.id.signup_PW);
                signup_PW2 = findViewById(R.id.signup_PW2);

                name = signup_NM.getText().toString();
                id = signup_ID.getText().toString();
                pw = signup_PW.getText().toString();
                pw2 = signup_PW2.getText().toString();
                if(name.length() == 0) {
                    Toast.makeText(SignupActivity.this, "이름은 필수 입력사항입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(id.length() == 0) {
                    Toast.makeText(SignupActivity.this, "아이디는 필수 입력사항입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(pw.length() == 0) {
                    Toast.makeText(SignupActivity.this, "비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                /*else if(pw!=pw2){
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                else{
                    //id, pw, name을 DB에 저장시키는 코드 필요
                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}
