package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Draw extends AppCompatActivity {
    private String pOne, pTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Bundle extras = getIntent().getExtras();
        pOne = extras.getString("Two");
        pTwo = extras.getString("One");

        Button goHome = findViewById(R.id.toHomefromWin);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Draw.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void rematch(){
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra("One", pOne);
        intent.putExtra("Two", pTwo);
        startActivity(intent);
    }
}