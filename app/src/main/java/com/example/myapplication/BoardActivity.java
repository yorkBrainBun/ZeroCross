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
    Button [][][][] buttons = new Button[3][3][3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        board = new UltimateBoard();

        setUpButtons();
    }

    private void setUpButtons(){
        String temp;
        for(int x1 = 0; x1 < 3;x1++){
            for(int y1 = 0; y1 < 3; y1++){
                for(int x2 = 0; x2 < 3; x2++){
                    for(int y2 = 0; y2 < 3; y2++){
                        temp = "b" + x1 + y1 + x2 + y2;
                        buttons[x1][y1][x2][y2] = (Button) findViewById(getResources().getIdentifier(temp, "id", getPackageName()));
                        buttons[x1][y1][x2][y2].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                    }
                }
            }
        }
    }
}