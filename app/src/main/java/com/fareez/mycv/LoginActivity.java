package com.fareez.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    String strUsername,strPassword;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        strUsername = "fareez";
        strPassword = "123456";
        sp = getSharedPreferences("SPLogin", Context.MODE_PRIVATE);

        Boolean isLoggedIn = sp.getBoolean("isLoggedin",false);

        if (isLoggedIn) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etUsername.getText().toString().equals(strUsername) && etPassword.getText().toString().equals(strPassword)) {

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isLoggedin",true);
                    editor.putString("ssUsername",etUsername.getText().toString());
                    editor.apply();

                    Intent loginIntent = new Intent(getApplicationContext(),MainActivity.class);
                    loginIntent.putExtra("intentUsername",etUsername.getText().toString());
                    startActivity(loginIntent);
                } else {
                     Toast.makeText(getApplicationContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}