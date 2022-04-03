package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WinScreen extends AppCompatActivity {


    private static final String FILE_NAME= "leaderboard.txt";
    private static final String SCORE_FILE = "score.txt";

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

        if(winner.equals("Guest 1") || winner.equals("Guest 2")){

        }else{
            addScore();
        }

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
                Intent intent = new Intent(WinScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void rematch(){
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra("One",loser);
        intent.putExtra("Two",winner);
        startActivity(intent);
    }

    public void addScore(){
        FileInputStream fis =null;
        FileInputStream fis1 =null;
        FileOutputStream fos1 = null;
        List<Integer> scores = new ArrayList<>();

        try {
            int counter = 0;
            int index;
            fos1 = openFileOutput(SCORE_FILE, MODE_APPEND);
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;

            fis1 = openFileInput(SCORE_FILE);
            InputStreamReader isr1 = new InputStreamReader(fis1);
            BufferedReader br1 = new BufferedReader(isr1);

            while ((text = br.readLine()) != null){
                scores.add(Integer.parseInt(br1.readLine()));
                if(text.equals(winner)){
                    scores.set(counter,scores.get(counter)+1);
                }
                counter++;
            }
            clear();
            PrintWriter pw1 = new PrintWriter(fos1);
            for(int i: scores){
                pw1.println(i);
            }
            pw1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clear(){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(SCORE_FILE, MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}