package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinScreen extends AppCompatActivity {

    private Button rematch;
    private Button goHome;
    String winner;
    String loser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
        Bundle extras = getIntent().getExtras();
        winner = extras.getString("Winner");
        loser = extras.getString("Loser");

        TextView displayWinner = findViewById(R.id.winDisplay);
        displayWinner.setText(winner + " wins");
        rematch = findViewById(R.id.rematch);
        rematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rematch();
            }
        });

        goHome = findViewById(R.id.toHomefromWin);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void rematch(){
        if(winner.equals("Guest 1") || winner.equals("Guest 2")){

        }else{

        }
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra("One",loser);
        intent.putExtra("Two",winner);
        startActivity(intent);
    }


}