package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button leaderboard = findViewById(R.id.LeaderBoard);
        leaderboard.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity2.class)));

        Button game = findViewById(R.id.button6);
        game.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BoardActivity.class)));
    }

}

