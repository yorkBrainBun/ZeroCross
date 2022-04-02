package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button HTP;
    private Button loginClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button leaderboard = findViewById(R.id.LeaderBoard);
        leaderboard.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, MainActivity2.class))
        );

        HTP = findViewById(R.id.howtoplay);
        HTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHowToPlay();
            }
        });

        loginClick = findViewById(R.id.button6);
        loginClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openHowToPlay(){
        Intent intent = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent = new Intent(this, PlayerOneLogin.class );
        startActivity(intent);
    }

}

