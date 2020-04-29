package com.example.login_practice4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button signup_fin_btn;
    EditText signup_ID, signup_PW;
    String ID, PW;

    int version=1;
    DatabaseOpenHelper helper;
    SQLiteDatabase database;

    String sql;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);


        signup_ID = findViewById(R.id.signup_ID);
        signup_PW = findViewById(R.id.signup_PW);

        helper = new DatabaseOpenHelper(SignupActivity.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        signup_fin_btn = findViewById(R.id.signup_fin);
        signup_fin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ID = signup_ID.getText().toString();
                PW = signup_PW.getText().toString();

                if(ID.length() == 0 || PW.length() == 0) {
                    //아이디와 비밀번호는 필수 입력사항입니다.
                    Toast toast = Toast.makeText(SignupActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + ID + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 0){
                    Toast.makeText(getApplicationContext(), "존재하는 id 입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    //id, pw, name을 DB에 저장시키는 코드 필요
                    helper.insertUser(database, ID, PW);
                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }
}