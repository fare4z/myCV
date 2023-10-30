package com.fareez.mycv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvUsername;
SharedPreferences sp;
CardView menuNote,menuFileStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        menuNote = findViewById(R.id.menuNote);
        menuFileStorage = findViewById(R.id.menuFileStorage);
        sp = getSharedPreferences("SPLogin", Context.MODE_PRIVATE);
        String Username = sp.getString("ssUsername","NULL");
        tvUsername.setText("Welcome " + Username);

        menuNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NotaActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item ) {

        switch (item.getItemId()){
            case R.id.back:
                Intent itnBack = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(itnBack);
                break;
            case R.id.logout:
                Intent itnLogout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(itnLogout);
                break;
        }

        // Depend on java sdk version

//        if (item.getItemId() == R.id.back) {
//            Intent itnBack = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(itnBack);
//        } else if (item.getItemId() == R.id.logout) {
//            Intent itnLogout = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(itnLogout);
//        }

        return super.onOptionsItemSelected(item);
    }
}