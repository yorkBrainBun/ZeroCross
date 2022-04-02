package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button HTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button leaderboard = findViewById(R.id.LeaderBoard);
        leaderboard.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, MainActivity2.class))
        );

        Button game = findViewById(R.id.button6);
        game.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, BoardActivity.class))
        );

        HTP =(Button) findViewById(R.id.button7);
        HTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHowToPlay();
            }
        });
    }
    public void openHowToPlay(){
        Intent intent = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }

}

