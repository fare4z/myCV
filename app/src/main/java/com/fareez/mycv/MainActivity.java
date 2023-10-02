package com.fareez.mycv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);

        Bundle extras = getIntent().getExtras();
        String Username = extras.getString("intentUsername");

        tvUsername.setText("Welcome " + Username);


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
        return super.onOptionsItemSelected(item);
    }
}