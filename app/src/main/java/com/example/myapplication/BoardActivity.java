package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.game.Board;
import com.example.myapplication.game.UltimateBoard;

public class BoardActivity extends AppCompatActivity {
    private UltimateBoard board;
    private boolean isFirstTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        board = new UltimateBoard();
    }


    public void onClick(View view) {
    }
}