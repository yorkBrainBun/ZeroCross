package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoard extends AppCompatActivity {

    private static final String FILE_NAME= "leaderboard.txt";
    private static final String SCORE_FILE = "score.txt";
    TextView[] tops = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        for(int i = 1; i <= 5; i++){
            tops[i-1] = findViewById(getResources().getIdentifier("top" + i, "id", getPackageName()));
        }
        load();

        Button button = findViewById(R.id.goHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaderBoard.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void load (){
        FileInputStream fis =null;
        FileInputStream fis1 =null;
        List<Integer> scores = new ArrayList<>();
        List<String> names = new ArrayList<>();

        try {
            int counter = 0;
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;

            fis1 = openFileInput(SCORE_FILE);
            InputStreamReader isr1 = new InputStreamReader(fis1);
            BufferedReader br1 = new BufferedReader(isr1);

            while ((text = br.readLine()) != null){
                names.add(text);
                scores.add(Integer.parseInt(br1.readLine()));
                System.out.println(scores.get(counter));
                counter++;
            }
            counter = 0;
            int[] top5index = top5Index(new ArrayList(scores));
            for (int i: top5index){
                tops[counter] = findViewById(getResources().getIdentifier("top"+(counter+1), "id", getPackageName()));
                tops[counter].setText(names.get(i) + "  " + scores.get(i));
                counter++;
            }
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

    public int[] top5Index(List array){
        if(array.size() != 0){
            int max = 0, index;
            int size;
            if (array.size() < 5){
                size = array.size();

            }else{
                size = 5;
            }
            int large[] = new int[size];
            for (int j = 0; j < large.length; j++) {
                max = (int)array.get(0);
                index = 0;
                for (int i = 1; i < array.size(); i++) {
                    if (max < (int) array.get(i)) {
                        max = (int) array.get(i);
                        index = i;
                    }
                }
                large[j] = index;
                array.set(index,Integer.MIN_VALUE);
            }
            return large;
        }
        return new int[array.size()];
    }
}
